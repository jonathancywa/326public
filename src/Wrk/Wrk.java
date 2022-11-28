package Wrk;

import Ctrl.Ctrl;

import beans.User;
import ch.emf.info.robot.links.Robot;
import java.io.IOException;
import java.util.List;

/**
 * @author GamezJ
 * @version 1.0
 * 
 */
public class Wrk implements ItfWrkTcpWrk {

    private Ctrl refCtrl;
    private WrkJDBC refWrkDb;
    private Robot robot;
    private WrkRobotControl wrkRobotControl = new WrkRobotControl();
    private WrkRobotVideo wrkRobotVideo = null;
    private WrkTCP wrkTcp;
    private List<User> users;

    public Wrk() {
        refWrkDb = new WrkJDBC();
    }

    /**
     * permet d'afficher du text sur le lcd
     * @param string String a afficher sur le lcd
     */
    public void afficheLcd(String string) {
        wrkTcp.EnvoieMessage(string);
    }
    /**
     * 
     * @param refCtrl refCtrl
     */

    public void setRefCtrl(Ctrl refCtrl) {
        this.refCtrl = refCtrl;
    }

    /**
     * permet de definir l'utilisateur actuellement connecté
     * @param user utilisateur actuellement connecté
     */
    public void setConnectedUser(User user) {
        
    }

    /**
     * envoie au wrkRobotControl les commandes.
     * @param string touche appuyé et angle si joystick (touche:angle,magnitude)
     */
    public void setMouvement(String[] string) {

        wrkRobotControl.setMouvement(string);
    }

    /**
     *
     * @param image image a afficher
     */
    public void traitementVideo(byte[] image) {

        refCtrl.showVideo(image);
    }

    /**
     *
     * @param user utilisateur a ajouter
     */
    public void ajouterUser(User user) {

    }

    /**
     *permet de lire les utilisateur de la base de donnée
     * 
     */
    public List<User> lireUser() {
        return refWrkDb.dbLirePersonnes();
    }

    /**
     *
     * @param login nom d'utilisateur pour le login
     * @param password mot de passe pour le login
     */
    public void loginUser(String login, String password) throws IOException {
        if (!refWrkDb.dbEstConnectee()) {

            refWrkDb.connecter("mydb");
        }
        wrkTcp.EnvoieMessage("login;" + refWrkDb.lireUser(login, password));
    }

    public void badgLogin(String badge) {
        wrkTcp.EnvoieMessage("save;" + true);
    }
/**
 * permet de créer un nouvelle utilisateur
 * @param login login de l'utilisateur
 * @param password mot de passe de l'utilisteur
 */
    public void createUser(String login, String password) {
        User u = new User();
        u.setLogin(login);
        u.setPassword(password);
        refWrkDb.dbCreerPersonne(u);
//        wrkTcp.EnvoieMessage("badge;" + refWrkDb.dbCreerPersonne(u));
    }

    /**
     * permet de suprimer un utilisateur
     * @param user utilisateur a supprimer
     * 
     */
    public void supprimerUser(User user) {
        refWrkDb.dbSupprimerUser(user);
    }
/**
 * permet de recupérer la vidéo du robot
 * @return retourne l'image
 */
    public byte[] getVideo() {

        return robot.getLastImage();
    }
/**
 * permet de démarrer le robot
 * @param robot robot a utiliser
 */
    public void startRobot(Robot robot) {
        wrkRobotVideo = new WrkRobotVideo();
        wrkRobotVideo.setRefWrk(this);
        if (robot != null) {
            System.out.println(robot);

            wrkRobotVideo.initialise(robot);
            if (robot.isConnected()) {
                wrkRobotVideo.setRunning(true);
                wrkRobotControl.setRobot(robot);
                wrkRobotVideo.start();
            } else {

            }

        }

    }
    /**
     * permet de tuer le thread robot
     * @param robot robot a tuer
     */

    public void stopRobot(Robot robot) {
        wrkRobotVideo.setRunning(false);

        try {
            wrkRobotVideo.join();

        } catch (Exception e) {
            System.out.println(e);
        }
        wrkRobotVideo.disconnect(robot);
        wrkRobotVideo = null;

    }
/**
 * démarre les thread tcp et la connexion a la base de donnée
 */
    public void demarrerServeur() {
        wrkTcp = new WrkTCP(this);
        wrkTcp.demarrerServeur(8888);
        wrkTcp.start();
        try {
           refWrkDb.connecter("mydb"); 
        } catch (Exception e) {
        }
        

    }
}//end Wrk

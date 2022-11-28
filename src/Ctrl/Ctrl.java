package Ctrl;

import Ihm.CtrlIhm;
import Ihm.Ihm;
import Wrk.Wrk;
import beans.Grade;
import beans.User;
import ch.emf.info.robot.links.Robot;
import java.util.List;
import javafx.application.Platform;

/**
 * Contrôleur principale de l'application
 *
 * @author GamezJ
 * @version 1.0
 *
 */
public class Ctrl implements CtrlIhm {
    
    private Ihm refIhm;
    private Wrk refWrk;
    private Robot robot = null;
    
    public Ctrl() {
        
    }
    
    public void setRefIhm(Ihm refIhm) {
        this.refIhm = refIhm;
    }
    
    public void setRefWrk(Wrk refWrk) {
        this.refWrk = refWrk;
    }
    
    public void hashPasword() {
        //     refIhm.showVideo(refWrk.getVideo());
        refWrk.afficheLcd("co;true");
    }
    
    public void start() {
        refIhm.start();
        refWrk.demarrerServeur();
        
    }
    
    public boolean robotIsConnected() {
        boolean retour = false;
        
        if (robot != null) {
            
            retour = robot.isConnected();
        }
        return retour;
    }
    
    public void initialiseRobot() {
        robot = new Robot();
        
        refWrk.startRobot(robot);
        
    }
    
    public void deconnecterRobot() {
        refWrk.stopRobot(robot);
        robot = null;
    }

    /**
     *
     * @param login
     * @param password
     */
    public void addUser(String login, String password) {
        refWrk.createUser(login, password);
    }

    /**
     *
     * @param user
     */
    public void deleteUser(User user) {
        refWrk.supprimerUser(user);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public List<User> getUser() {
        return refWrk.lireUser();
    }
    
    public void showVideo(byte[] img) {
        Platform.runLater(() -> {
            //  Image img =  new Image(new ByteArrayInputStream(image));
            //  img.

            refIhm.showVideo(img);
        });
        
    }
    /**
     * permet de recupérer les grades
     * @return la liste des grades
     */
    public List<Grade> getGrade(){
        return refWrk.lireGrade();
    }
    
}//end Ctrl

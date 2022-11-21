package Ctrl;

import Ihm.CtrlIhm;
import Ihm.CtrlIhmGestionUser;
import Ihm.Ihm;
import Wrk.Wrk;
import beans.User;
import ch.emf.info.robot.links.Robot;
import java.util.List;
import javafx.application.Platform;

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:11
 */
public class Ctrl implements CtrlIhm, CtrlIhmGestionUser {

    private Ihm refIhm;
    private Wrk refWrk;
    private Robot robot = null;
    public User m_User;

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
    public void deconnecterRobot(){
        refWrk.stopRobot(robot);
        robot = null;
    }

    /**
     *
     * @param nom
     * @param prenom
     */
    public void addUser(String nom, String prenom) {

    }

    /**
     *
     * @param user
     */
    public void deleteUser(User user) {

    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public User getM_User() {
        return m_User;
    }

    @Override
    public List<User> getUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void showVideo(byte[] img) {
        Platform.runLater(() -> {
            //  Image img =  new Image(new ByteArrayInputStream(image));
            //  img.

            refIhm.showVideo(img);
        });

    }

}//end Ctrl

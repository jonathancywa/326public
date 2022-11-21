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
	private Robot robot;
	public User m_User;

	public Ctrl(){

	}

    public void setRefIhm(Ihm refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWrk(Wrk refWrk) {
        this.refWrk = refWrk;
    }

	public void finalize() throws Throwable {

	}
	public void hashPasword(){
            refIhm.showVideo(refWrk.getVideo());
	}

	public void start(){
            refIhm.start();
        
	}

	public void initialiseRobot(){
            refWrk.startRobot();
            
            
            
             
	}

	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public void addUser(String nom, String prenom){

	}

	/**
	 * 
	 * @param user
	 */
	public void deleteUser(User user){

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
    public void showVideo(byte[] img){
          Platform.runLater(() -> {
        //  Image img =  new Image(new ByteArrayInputStream(image));
        //  img.
          
           refIhm.showVideo(img);
        });
        
    }

	
}//end Ctrl
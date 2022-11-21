package Wrk;

import Ctrl.Ctrl;

import beans.User;
import ch.emf.info.robot.links.Robot;
import java.util.List;

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public class Wrk implements ItfWrkTcpWrk{

	private Ctrl refCtrl;
	private WrkDb refWrkDb;
	private Robot robot;
	private WrkRobotControl wrkRobotControl;
	private WrkRobotVideo wrkRobotVideo = null;
        private WrkTCP wrkTcp;
        private List<User> users;



	public Wrk(){
          
	}

	
	/**
	 * 
	 * @param string
	 */
	public void afficheLcd(String string){

	}

    public void setRefCtrl(Ctrl refCtrl) {
        this.refCtrl = refCtrl;
    }

	/**
	 * 
	 * @param user
	 */
	public void setConnectedUser(User user){

	}

	/**
	 * 
	 * @param string
	 */
	public void setMouvement(String[] string){

	}

	/**
	 * 
	 * @param image
	 */
	public void traitementVideo(byte[] image){
            
       refCtrl.showVideo(image);
	}

	/**
	 * 
	 * @param string
	 */
	public void ajouterUser(String[] string){

	}

	/**
	 * 
	 * @param string
	 */
	public void lireUser(String[] string){

	}

	/**
	 * 
	 * @param string
	 */
	public void supprimerUser(String[] string){

	}

	public byte[] getVideo(){
            
            return robot.getLastImage();
	}

	public void startRobot(Robot robot){
          wrkRobotVideo = new WrkRobotVideo();
            wrkRobotVideo.setRefWrk(this);
            if (robot != null) {
                System.out.println(robot);
                
                wrkRobotVideo.initialise(robot);
                if (robot.isConnected()) {
                     wrkRobotVideo.setRunning(true);
                wrkRobotVideo.start();
                }else
                {
                    
                }
               
               
            }
           
            
            
	} 
        public void stopRobot(Robot robot){
             wrkRobotVideo.setRunning(false);
               
                try {
                 wrkRobotVideo.join();
                
            } catch (Exception e) {
                    System.out.println(e);
            }
                wrkRobotVideo.disconnect(robot); 
                wrkRobotVideo = null;
                
            }
        public void demarrerServeur() {
        wrkTcp = new WrkTCP(this);
        wrkTcp.demarrerServeur(8888);
        wrkTcp.start();
    }
}//end Wrk
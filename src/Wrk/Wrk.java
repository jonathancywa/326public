package Wrk;

import Ctrl.Ctrl;

import beans.User;
import ch.emf.info.robot.links.Robot;

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
	private WrkRobotVideo wrkRobotVideo;
	public WrkRobotVideo m_WrkRobotVideo;
	public WrkTCP m_WrkTCP;
	public WrkRobotControl m_WrkRobotControl;
	public WrkPhidget m_WrkPhidget;
	public WrkUdp m_WrkUdp;
	private WrkDb m_WrkDb;
	public User m_User;

	public Wrk(){
            wrkRobotVideo = new WrkRobotVideo();
	}

	public void finalize() throws Throwable {

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

	public void startRobot(){
            robot = new Robot();
            wrkRobotVideo.setRefWrk(this);
            if (robot != null) {
                System.out.println(robot);
                
                wrkRobotVideo.initialise(robot);
                
               
                wrkRobotVideo.start();
            }
            
            
	}
}//end Wrk
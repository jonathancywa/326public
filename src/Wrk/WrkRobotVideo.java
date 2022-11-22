package Wrk;

import ch.emf.info.robot.links.Robot;

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public class WrkRobotVideo extends Thread {

    private WrkUdp refWrkUdp;
    private Robot robot;
    private boolean running;
    private String ip = "192.168.53.188";
    private int id = 43296;
    private int password = 1946706066;
    private Wrk refWrk;

    public WrkRobotVideo() {
        super("Thread Etat Robot");
    }

  

    public byte[] getVideo() {
        return robot.getLastImage();
    }

    /**
     *
     * @param robot
     */
    public boolean initialise(Robot robot) {

        this.robot = robot;
        boolean retour = false;
        if (robot.isConnected()) {
            System.out.println("robot déjà en ligne");
            retour = true;
        } else {

            try {
                robot.connect(ip, 43296, 1946706066);
                //robot.undock();
                System.out.println("robot connecté");
                

                retour = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return retour;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean disconnect(Robot robot) {
        boolean retour = false;

        if (robot.isConnected()) {
            try {

                //robot.dock();
                robot.disconnect();
                retour = true;
            } catch (Exception e) {
            }

        } else {

        }
        return retour;
    }

    public void run() {
        if (robot == null) {
            initialise(robot);
        } else if (!robot.isConnected()) {
            try {
                this.join();
            } catch (Exception e) {
            }
            running = false;

        }

        while (running) {
            try {
                _sleep(15);

            } catch (Exception e) {
            }

            refWrk.traitementVideo(robot.getLastImage());

        }

    }

    private void _sleep(int millis) {
        try {
            sleep(millis);
        } catch (InterruptedException ex) {
            System.err.println("Erreur lors du sleep du thread " + super.getName()
                    + ". \n" + ex.getMessage());
        }
    }

    public void setRefWrk(Wrk refWrk) {
        this.refWrk = refWrk;
    }
}//end WrkRobotVideo

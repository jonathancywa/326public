package Wrk;

import ch.emf.info.robot.links.Robot;

/**
 * @author GamezJ
 * @version 1.0
 * 
 */
public class WrkRobotVideo extends Thread {

    private WrkUdp refWrkUdp;
    private Robot robot;
    private boolean running;
    private String ip = "192.168.53.188";
    private int id = 43296;
    private int password = 1946706066;
    private Wrk refWrk;

    /**
     *
     */
    public WrkRobotVideo() {
        super("Thread Etat Robot");
        refWrkUdp = new WrkUdp();
    }

    /**
     *
     * @return les image reçu du robot
     */
    public byte[] getVideo() {
        return robot.getLastImage();
    }

    /**
     *
     * @param robot le robot a utiliser
     * @return true si la connexion a réussit
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

    /**
     *
     * @param running 
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     *
     * @param robot le robot a deconnecter
     * @return true si l'opération a réussit
     */
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

    /**
     *permet de lancer le thread
     */
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
            refWrkUdp.sendVideod(robot.getLastImage());

        }

    }
/**
 * permet de mettre le thread en pause pour un temps voulu
 * @param millis 
 */
    private void _sleep(int millis) {
        try {
            sleep(millis);
        } catch (InterruptedException ex) {
            System.err.println("Erreur lors du sleep du thread " + super.getName()
                    + ". \n" + ex.getMessage());
        }
    }

    /**
     *permet de seter la référence du wrk
     * @param refWrk le wrk a utiliser
     */
    public void setRefWrk(Wrk refWrk) {
        this.refWrk = refWrk;
    }
}//end WrkRobotVideo

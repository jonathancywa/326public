package Wrk;

import ch.emf.info.robot.links.Robot;

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public class WrkRobotControl implements ItfWrkRobotCtrlClient {

    private Robot robot;
    private boolean running;

    public WrkRobotControl() {

    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     *
     * @param touche,posx,posy
     */
    public void setMouvement(String[] string) {
        String touche = string[1];
        System.out.println("touche " + touche);
        String[] cmd = touche.split(",");
        System.out.println("la touhe " + cmd[0] + " detecté");
        switch (cmd[0]) {
            case "joysticG":
                short vitesse =  (short)(Double.parseDouble(cmd[2]) * 900);
                
               
                System.out.println("je vais a " + vitesse);
                robot.setLeftSpeed(vitesse);
                robot.setRightSpeed(vitesse);
                System.out.println("je tourne");
                break;
            default:
                System.out.println("pas de touche detecté");
        }

    }
}//end WrkRobotControl

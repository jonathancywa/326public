package Wrk;

import ch.emf.info.robot.links.Robot;
import ch.emf.info.robot.links.bean.RobotState;

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
        System.out.println("la touche " + cmd[0] + " detecté");
        switch (cmd[0]) {
            case "joysticG":
                double sin = (Math.sin(Double.parseDouble(cmd[1]))) * -1;
                short vitesseG = (short) (Double.parseDouble(cmd[2])  * sin * 500);
                short vitesseD = (short) (Double.parseDouble(cmd[2])  * (Math.cos(Double.parseDouble(cmd[1]))* 500));
                System.out.println("Direction: valeur angle "+cmd[1]+"° parse: "+Double.parseDouble(cmd[1]) +" ");
                System.out.println(Math.sin(80));
                System.out.println(Math.sinh(80));
                System.out.println("je vais a G" + vitesseG + " je vais a d " + vitesseD);
                robot.setLeftSpeed(vitesseG);
                robot.setRightSpeed(vitesseD);
                System.out.println("je tourne");
                break;
            case "joysticD":
                System.out.println("JoysticD " + cmd[1]);
                if ("haut".equals(cmd[1])) {

                    robot.setHeadDirection(RobotState.HeadDirection.UP);
                } else if ("bas".equals(cmd[1])) {
                    robot.setHeadDirection(RobotState.HeadDirection.DOWN);

                } else {
                    robot.setHeadDirection(RobotState.HeadDirection.NONE);
                }
                break;
            default:
                System.out.println("pas de touche detecté");
        }

    }
}//end WrkRobotControl

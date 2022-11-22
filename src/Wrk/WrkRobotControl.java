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
        //System.out.println("touche " + touche);
        String[] cmd = touche.split(",");
       // System.out.println("la touche " + cmd[0] + " detecté");
        int angle = (int) Double.parseDouble(cmd[1]);
        switch (cmd[0]) {
            case "joysticG":
                double sDeg = Math.sin(Double.parseDouble(cmd[1]) * Math.PI / 180);
                double cosDeg = Math.cos(Double.parseDouble(cmd[1]) * Math.PI / 180);
                double sin = (Math.sin(Double.parseDouble(cmd[1])));
                 short vitesseG = 0;
                 short vitesseD = 0;
                if (angle <= 90) {
                   vitesseG = (short) (Double.parseDouble(cmd[2]) * (cosDeg * 850) + (sDeg * 500));
                   vitesseD = (short) ((Double.parseDouble(cmd[2]) * cosDeg * 850) - (sDeg * 500));
                   // System.out.println("Multiplicateur G1 "+ (cosDeg * 900)+" Multiplicateur g2 "+ (sDeg * 500));
                }else if (angle > 90){
                    System.out.println("> 90");
                   vitesseG = (short) (Double.parseDouble(cmd[2]) * (cosDeg * 850) + (sDeg * 500));
                   vitesseD = (short) ((Double.parseDouble(cmd[2]) * cosDeg * 850) - (sDeg * 500));
                }
                
                    System.out.println("Direction: valeur angle " + cmd[1] + "° magnitude: " + cmd[2] + " ");
                System.out.println("Tangante :" + Math.tan(Double.parseDouble(cmd[1])) * Math.PI / 180);

                System.out.println("Valeur sin " + sDeg );
                System.out.println("Valeur cos " + Math.cos(cosDeg));
              
                
                  System.out.println("je vais a G" + vitesseG + " je vais a d " + vitesseD);
                
                if (vitesseG > 999 || vitesseD > 999) {
                    System.out.println("======================== Error ========================");
                }
              //  System.out.println("je tourne");
                break;
            case "joysticD":
                System.out.println("JoysticD " + cmd[1]);

                break;
            default:
                System.out.println("pas de touche detecté");
        }

    }
}//end WrkRobotControl

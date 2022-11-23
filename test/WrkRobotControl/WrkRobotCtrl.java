/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WrkRobotControl;

import Wrk.Wrk;
import Wrk.WrkRobotControl;
import ch.emf.info.robot.links.Robot;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author GamezJ
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WrkRobotCtrl {

    private WrkRobotControl wrkrbc = new WrkRobotControl();
    private Wrk wrk = new Wrk();
    private Robot robot = new Robot();

    public WrkRobotCtrl() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        wrk.startRobot(robot);
    }

    @After
    public void tearDown() {
    }

    private void setMouvement(String[] string, boolean debug) {
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
                } else if (angle > 90) {
//                    System.out.println("> 90");
                    vitesseG = (short) (Double.parseDouble(cmd[2]) * (cosDeg * 850) + (sDeg * 500));
                    vitesseD = (short) ((Double.parseDouble(cmd[2]) * cosDeg * 850) - (sDeg * 500));
                }
                if (debug == true) {
                    System.out.println("Direction: valeur angle " + cmd[1] + "° magnitude: " + cmd[2] + " ");
                    System.out.println("Tangante :" + Math.tan(Double.parseDouble(cmd[1])) * Math.PI / 180);

                    System.out.println("Valeur sin " + sDeg);
                    System.out.println("Valeur cos " + Math.cos(cosDeg));

                }
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

    @Test
    public void test01_connexionRobot() {

        wrk.setMouvement(new String[]{"", "joysticG,80,0.5"});
        //  setMouvement(new String[]{"", "joysticG,40,1"}, true);

        for (int i = 0; i <= 360; i++) {
            // setMouvement(new String[]{"", "joysticG,"+i+",1"}, false); 
            //  wrk.setMouvement(new String[]{"", "joysticG,"+i+",1"});

        }
        long running = System.currentTimeMillis();

        System.out.println("debut");
        while (System.currentTimeMillis() - running < 4000) {
//            System.out.println("différence de temp "+ (System.currentTimeMillis() - running));
            wrk.setMouvement(new String[]{"", "joysticG,0,0.7"});

        }
        while (System.currentTimeMillis() - running < 1000) {
//            System.out.println("différence de temp "+ (System.currentTimeMillis() - running));
            wrk.setMouvement(new String[]{"", "joysticG,90,0.5"});

        }
         while (System.currentTimeMillis() - running < 4000) {
//            System.out.println("différence de temp "+ (System.currentTimeMillis() - running));
            wrk.setMouvement(new String[]{"", "joysticG,0,1"});

        }
        wrk.setMouvement(new String[]{"", "joysticG,20,0"});

    }

    @Test
    public void test02_deConnexionRobot() {

    }

    @Test
    public void test3_video() {

    }
}

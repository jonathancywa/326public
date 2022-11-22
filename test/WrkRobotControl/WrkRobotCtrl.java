/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WrkRobotControl;

import Wrk.Wrk;
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
 */ @FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class WrkRobotCtrl {
   private Wrk wrk = new Wrk();


    
    public WrkRobotCtrl(){
}
  
    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    private void setMouvement(String[] string) {
        String touche = string[1];
        System.out.println("touche " + touche);
        String[] cmd = touche.split(",");
        System.out.println("la touche " + cmd[0] + " detecté");
        switch (cmd[0]) {
            case "joysticG":
                double sinDeg = (Double.parseDouble(cmd[1])*Math.PI/180);
                
                double sin = (Math.sin(Double.parseDouble(cmd[1]))) ;
                short vitesseG = (short) (Double.parseDouble(cmd[2])  * sinDeg * 900);
                short vitesseD = (short) (Double.parseDouble(cmd[2])  * (Math.cos(Double.parseDouble(cmd[1]))* 500));
                System.out.println("Direction: valeur angle "+cmd[1]+"° parse: "+Double.parseDouble(cmd[1]) +" ");
                System.out.println(Math.sin(Double.parseDouble(cmd[1])));
                System.out.println(Math.sin(10));
                System.out.println(Math.asin(Double.parseDouble(cmd[1])));
                System.out.println(Math.sinh(Double.parseDouble(cmd[1])));
                System.out.println("je vais a G" + vitesseG + " je vais a d " + vitesseD);
               
                System.out.println("je tourne");
                break;
            case "joysticD":
                System.out.println("JoysticD " + cmd[1]);
              
                break;
            default:
                System.out.println("pas de touche detecté");
        }

    }
    @Test
    public void test01_connexionRobot(){
       
      // wrk.setMouvement(new String[]{"","joysticG,80,0.5"});
        setMouvement(new String[]{"","joysticG,0,1"});
        
    }
    @Test
    public void test02_deConnexionRobot(){
        
       
        
    }
    @Test
    public void test3_video()
    {
      
    }
}



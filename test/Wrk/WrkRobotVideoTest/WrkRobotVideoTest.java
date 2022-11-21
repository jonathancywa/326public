/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wrk.WrkRobotVideoTest;

import Wrk.WrkRobotVideo;
import ch.emf.info.robot.links.Robot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author GamezJ
 */

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class WrkRobotVideoTest {
    private static Robot robot;
    
    public WrkRobotVideoTest(){
}
     private static WrkRobotVideo wrkRobotVideo;
    @BeforeClass
    public static void setUpClass() {
        wrkRobotVideo = new WrkRobotVideo();
         robot = new Robot();
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
    @Test
    public void test01_connexionRobot(){
       
        assertTrue(wrkRobotVideo.initialise(robot));
        
    }
    @Test
    public void test02_deConnexionRobot(){
        
        assertTrue(wrkRobotVideo.disconnect(robot));
        
    }
    @Test
    public void test3_video()
    {
        Assert.assertNotNull(wrkRobotVideo.getVideo());
        System.out.println(wrkRobotVideo.getVideo().length);
    }
}

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
    @Test
    public void test01_connexionRobot(){
       
       wrk.setMouvement(new String[]{"","joysticG,80,0.5"});
        
        
    }
    @Test
    public void test02_deConnexionRobot(){
        
       
        
    }
    @Test
    public void test3_video()
    {
      
    }
}



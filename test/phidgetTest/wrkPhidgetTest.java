/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phidgetTest;

import Wrk.WrkPhidget;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
public class wrkPhidgetTest {

    private static WrkPhidget wrkPhidget;
    private static String ID = "636109";

    @BeforeClass
    public static void setUpClass() {
        wrkPhidget = new WrkPhidget();
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
    public void test01_initialise() {
        Assert.assertTrue(wrkPhidget.initialise(ID));

    }
    @Test
    public void test02_afficher(){
       wrkPhidget.afficher("Affichage de text");
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WrkDBTest;

import Wrk.WrkDb;
import Wrk.WrkJDBC;
import beans.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 5.1
 */
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class WrkDbTest {
   
    private static WrkJDBC wrkDb;
 
    @BeforeClass
    public static void setUpClass() {
      wrkDb = new WrkJDBC();
        System.out.println("classe ok");
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
    public void test01_connexionDB(){
        try {
            wrkDb.connecter("mydb");
      
        } catch (Exception e) {
        }
       
        
    }
    @Test
    public void test02_deConnexionDB(){
          try {
        
 
        } catch (Exception e) {
        }
       
        
    }
    
    @Test
    public void test3_estConnecte(){
        Assert.assertTrue(wrkDb.dbEstConnectee());
       
        
    }
    @Test
    public void test4_lire()
    {
       System.out.println( "Test de dbLirePersonnes..." );
        List<User> liste = wrkDb.dbLirePersonnes();
        assertNotNull( liste );
        assertFalse( liste.isEmpty() );
        for (User user : liste) {
            System.out.println(user.getNom() +" "+ user.getPrenom());
        }
        System.out.println( "  Il y a " + liste.size() + " user dans la BD." );
    }
    @Test
    public void test5_login()
    {
        Assert.assertTrue(wrkDb.lireUser("cywa", "1234"));
    }
    
}

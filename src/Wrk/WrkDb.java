package Wrk;

import beans.User;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 * @author GamezJ
 * @version 1.0
 *
 */
public class WrkDb implements ItfWrkDb {

    private String db;
    private String password;
    private String user;
    private Wrk refWrk;
    private List<User> users;

    public WrkDb() {
        entity = null;
        dbconnexion = null;
        et = null;
    }

    public void setWrk(Wrk wrk) {
        this.refWrk = wrk;
    }

    /**
     *
     * @param pu
     */
    public void dbConnecter(String pu) throws Exception {
       
       entity = Persistence.createEntityManagerFactory(pu);
        
        System.out.println("lol");   
        dbconnexion = entity.createEntityManager();
            et = dbconnexion.getTransaction();
            System.out.println("entity");
           
         
    }

    public void dbDeconnecter() {
        dbconnexion.close();
        entity.close();
        dbconnexion = null;
        entity = null;
    }

    public boolean dbIsConnected() {
        boolean result = false;
        if (dbconnexion != null) {
            result = dbconnexion.isOpen();
        }
        return result;
    }

    public void creerModifierUser(User user) {
        try {

        } catch (Exception e) {
        }
    }

    /**
     *
     * @param string
     */
    public void lire(String string) {

    }

    @Override
    public List<User> lireDb() {

        List<User> users = new ArrayList<>();

        try {

            Query query = dbconnexion.createNamedQuery("User.findAll");

            //Query query = em.createQuery( "SELECT p FROM Personne p" ); 
           // query.setHint(QueryHints.REFRESH, HintValues.TRUE);

            users = query.getResultList();

        } catch (Exception e) {

        }

        return users;

    }

    /**
     *
     * @param user
     */
    public void supprimerUser(User user) {

    }
    private EntityManagerFactory entity;
    private EntityManager dbconnexion;
    private EntityTransaction et;
}//end WrkDb

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */

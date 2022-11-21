package Wrk;

import beans.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public class WrkDb implements ItfWrkDb {

    private String db;
    private String password;
    private String user;

    public WrkDb() {
        emf = null;
        em = null;
        et = null;
    }

    /**
     *
     * @param user
     */
    public void dbConnecter(String pu) throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory(pu);
            em = emf.createEntityManager();
            et = em.getTransaction();
            if (!em.isOpen()) {
                throw new Exception("Erreur à l'ouverture de la db");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
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

        List<User> liste = new ArrayList<>();

        try {

            Query query = em.createNamedQuery("User.findAll");

            //Query query = em.createQuery( "SELECT p FROM Personne p" ); 
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);

            liste = query.getResultList();

        } catch (Exception e) {

        }

        return liste;

    }

    /**
     *
     * @param user
     */
    public void supprimerUser(User user) {

    }
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
}//end WrkDb

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */

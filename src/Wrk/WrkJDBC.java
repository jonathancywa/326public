/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wrk;

import beans.Grade;
import beans.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author GamezJ
 */
public class WrkJDBC {

    private Connection dbConnexion;

    private Properties lireProperties() throws IOException {
        Properties conf = new Properties();
        conf.load(new FileInputStream("config/mysql.conf"));
        return conf;
    }

    public void connecter(String nomDB) throws IOException {

        final String url = lireProperties().getProperty("URL_DB");

        final String user = lireProperties().getProperty("LOGIN_DB");

        final String pass = lireProperties().getProperty("PASSWORD_DB");

        try {

            dbConnexion = DriverManager.getConnection(url, user, pass);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void dbDeconnecter() {
        try {
            if (dbConnexion != null) {
                dbConnexion.close();
                dbConnexion = null;
            }
        } catch (SQLException ex) {

        }
    }

    public boolean dbEstConnectee() {
        boolean estConnecte = false;
        try {
            if ((dbConnexion != null) && dbConnexion.isValid(1)) {    // vérifie vraiment l'état de la connexion avec la BD
                estConnecte = true;
            }
        } catch (SQLException ex) {
        }

        return estConnecte;
    }

    public List<User> dbLirePersonnes() {
        final String SQL = "SELECT * FROM t_user ";//ORDER BY "arg"
        List<User> listeUser = new ArrayList<>();
        try (
                 Statement stm = dbConnexion.createStatement();  ResultSet rs = stm.executeQuery(SQL);) {
            while (rs.next()) {
                listeUser.add((userRs(rs)));
            }
        } catch (SQLException | NullPointerException ex) {
            listeUser = null;

        }

        return listeUser;
    }

    public boolean lireUser(String login, String password) {
        boolean retour = false;
        final String SQL_SELECT = "SELECT * FROM  t_user WHERE "
                + "login="
                + "?;";

        // préparation d'une requête d'insertion
        try ( PreparedStatement ps = dbConnexion.prepareStatement(SQL_SELECT)) {
            ps.setString(1, login);

            // exécution de la requête
            ResultSet rs = ps.executeQuery();

            // récuperation de la clé générée et stockage dans l'objet personne
            rs.next();

            if (rs.getString("password").equals(password)) {
                retour = true;
            }

//            p.setPkPers(rs.getInt(1));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return retour;
    }

    public void dbModifierPersonne(User p) {

//Activer la transaction 
        try {

// désactivation de l’auto-commit 
            dbConnexion.setAutoCommit(false);

            if (true) {

                dbConnexion.setAutoCommit(true);

            } else {

//                PreparedStatement ps = preparerRequeteModif(p);
//                if (ps.executeUpdate() == 1) {
//
//                    dbConnexion.commit();
//
//                } else {
//
//                    dbConnexion.rollback();
//
//                }
//réactiver l'auto-commit 
                dbConnexion.setAutoCommit(true);

            }

        } catch (SQLException ex) {

        }

    }

    private User userRs(ResultSet rs) {
        User p = new User();
        try {

            p.setLogin(rs.getString("login"));
            p.setPassword(rs.getString("password"));
            p.setBadge(rs.getBoolean("badgeOk"));
            p.setTag(rs.getString("badgId"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setGrade((Grade) rs.getObject("grade"));

        } catch (SQLException ex) {

        }
        return p;
    }

    /**
     * permet de créer un utilisateur dans la base de donnée.
     *
     * @param u utilisateur a passer a la base de donnée.
     */
    public boolean dbCreerPersonne(User u) {
        boolean retour = false;
        final String SQL_INSERT = "INSERT INTO t_user "
                + "(prenom, nom, login, password, badgId, badgeOk, fk_grade)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?);";

        // préparation d'une requête d'insertion
        try ( PreparedStatement ps = dbConnexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            if (u.getPrenom() != null) {
                ps.setString(1, u.getPrenom());
            } else {
                ps.setString(1, "/");
            }

            if (u.getNom() != null) {
                ps.setString(2, "/");
            } else {
                ps.setString(2, u.getNom());
            }
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());
            if (u.getTag() != null) {
                ps.setString(6, u.getTag());
            }else
            {
                ps.setBoolean(6, true);
            }
            ps.setBoolean(5, u.isBadge());
            ps.setInt(7, 2);

            // exécution de la requête
            int nb = ps.executeUpdate();

            // récuperation de la clé générée et stockage dans l'objet personne
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            retour = true;
//            p.setPkPers(rs.getInt(1));
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return retour;
    }

}

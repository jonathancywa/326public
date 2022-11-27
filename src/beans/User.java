/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author GamezJ
 */
public class User {
/**
 * constructeurs User
 * @param nom nom de l'utilisateur
 * @param prenom prenom de l'utilisateur
 * @param login identifiant de connexion de l'utilisateur
 * @param password mot de passe de l'utilisateur
 * @param tag id du tag de l'utilisateur
 * @param badge boolean, true si l'utilisateur ose utiliser un badge
 * @param grade Grade de l'utilisateur
 */
    public User(String nom, String prenom, String login, String password, String tag, boolean badge, Grade grade) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.tag = tag;
        this.badge = badge;
        this.grade = grade;
    }

    /**
     *
     */
    public User() {
    }

    /**
     * 
     * @param login
     * @param password
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
/**
 * retourne le nom de l'utilisateur
 * @return nom de l'utilisateur
 * 
 */
    public String getNom() {
        return nom;
    }

    /**
     * getter du nom
     * @return le prenom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return le login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @return le mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return l'id du tag de l'utilisateur
     */
    public String getTag() {
        return tag;
    }

    /**
     *
     * @return si l'utilisateur a le droit d'utiliser un badge
     */
    public boolean isBadge() {
        return badge;
    }

    /**
     *
     * @return le grade de l'utilisateur
     */
    public Grade getGrade() {
        return grade;
    }
    
    /**
     *
     * @param nom set le nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param prenom set le prenom de l'utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @param login set le login de l'utilisateur
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @param password set le mot de passe de l'utilisateur
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param tag set le tag de l'utilisateur
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     *
     * @param badge true définit le droit de créer un badge 
     */
    public void setBadge(boolean badge) {
        this.badge = badge;
    }

    /**
     *
     * @param grade set le grade
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * surcharge de la méthode toString
     * @return "nom : "+nom+" prenom : "+prenom+" login : "+login
     */
    @Override
    public String toString() {
        return "nom : "+nom+" prenom : "+prenom+" login : "+login; 
    }

    
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String tag;
    private boolean badge;
    private Grade grade;

}

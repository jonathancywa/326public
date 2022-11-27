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

    public User(String nom, String prenom, String login, String password, String tag, boolean badge, Grade grade) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.tag = tag;
        this.badge = badge;
        this.grade = grade;
    }

    

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getTag() {
        return tag;
    }

    public boolean isBadge() {
        return badge;
    }

    public Grade getGrade() {
        return grade;
    }
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setBadge(boolean badge) {
        this.badge = badge;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

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

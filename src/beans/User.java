/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 5.1
 */
@Entity
@Table(name = "t_user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByPKuser", query = "SELECT u FROM User u WHERE u.userPK.pKuser = :pKuser"),
    @NamedQuery(name = "User.findByPrenom", query = "SELECT u FROM User u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "User.findByNom", query = "SELECT u FROM User u WHERE u.nom = :nom"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByBadgId", query = "SELECT u FROM User u WHERE u.badgId = :badgId"),
    @NamedQuery(name = "User.findByFkGrade", query = "SELECT u FROM User u WHERE u.userPK.fkGrade = :fkGrade")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "nom")
    private String nom;
    @Column(name = "password")
    private String password;
    @Column(name = "badgId")
    private String badgId;
    @JoinColumn(name = "fk_grade", referencedColumnName = "pk_grade", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grade grade;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(int pKuser, int fkGrade) {
        this.userPK = new UserPK(pKuser, fkGrade);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBadgId() {
        return badgId;
    }

    public void setBadgId(String badgId) {
        this.badgId = badgId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPK != null ? userPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userPK == null && other.userPK != null) || (this.userPK != null && !this.userPK.equals(other.userPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.User[ userPK=" + userPK + " ]";
    }
    
}

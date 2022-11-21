/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 5.1
 */
@Entity
@Table(name = "t_grade")
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findByPkGrade", query = "SELECT g FROM Grade g WHERE g.pkGrade = :pkGrade"),
    @NamedQuery(name = "Grade.findByGrade", query = "SELECT g FROM Grade g WHERE g.grade = :grade")})
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_grade")
    private Integer pkGrade;
    @Column(name = "grade")
    private String grade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private List<User> userList;

    public Grade() {
    }

    public Grade(Integer pkGrade) {
        this.pkGrade = pkGrade;
    }

    public Integer getPkGrade() {
        return pkGrade;
    }

    public void setPkGrade(Integer pkGrade) {
        this.pkGrade = pkGrade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkGrade != null ? pkGrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.pkGrade == null && other.pkGrade != null) || (this.pkGrade != null && !this.pkGrade.equals(other.pkGrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Grade[ pkGrade=" + pkGrade + " ]";
    }
    
}

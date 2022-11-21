/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 5.1
 */
@Embeddable
public class UserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PK_user")
    private int pKuser;
    @Basic(optional = false)
    @Column(name = "fk_grade")
    private int fkGrade;

    public UserPK() {
    }

    public UserPK(int pKuser, int fkGrade) {
        this.pKuser = pKuser;
        this.fkGrade = fkGrade;
    }

    public int getPKuser() {
        return pKuser;
    }

    public void setPKuser(int pKuser) {
        this.pKuser = pKuser;
    }

    public int getFkGrade() {
        return fkGrade;
    }

    public void setFkGrade(int fkGrade) {
        this.fkGrade = fkGrade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pKuser;
        hash += (int) fkGrade;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPK)) {
            return false;
        }
        UserPK other = (UserPK) object;
        if (this.pKuser != other.pKuser) {
            return false;
        }
        if (this.fkGrade != other.fkGrade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.UserPK[ pKuser=" + pKuser + ", fkGrade=" + fkGrade + " ]";
    }
    
}

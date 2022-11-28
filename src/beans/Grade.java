
package beans;

/**
 *
 * @author GamezJ
 */
public class Grade {

    /**
     * grade
     * @param grade
     */
    public Grade(String grade) {
        this.grade = grade;
    }

    /**
     *
     * @return retourne le grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     *
     * @param grade set le grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getFk() {
        return fk;
    }

    public void setFk(int fk) {
        this.fk = fk;
    }
    
    
    
    
    
    
    private int fk;
    private String grade;
}

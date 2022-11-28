
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

    @Override
    public String toString() {
        return "Grade{ grade=" + grade + '}';
    }
    
    
    
    
    
    
    private int fk;
    private String grade;
}

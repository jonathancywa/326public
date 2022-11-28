
package beans;

/**
 *
 * @author GamezJ
 */
public class Grade {

    /**
     * constructeur grade
     * 
     */
    public Grade() {
      
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

    /**
     *
     * @return la fk du grade
     */
    public int getFk() {
        return fk;
    }

    /**
     *
     * @param fk
     */
    public void setFk(int fk) {
        this.fk = fk;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return  grade;
    }
    
    
    
    
    
    
    private int fk;
    private String grade;
}

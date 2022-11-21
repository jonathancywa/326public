/*

 */
package serveur_g04;

import Ctrl.Ctrl;
import Ihm.Ihm;
import Wrk.Wrk;

/**
 *
 * @author GamezJ
 */
public class Serveur_G04 {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ctrl ctrl = new Ctrl();
        Wrk wrk = new Wrk();
        Ihm ihm = new Ihm();
        ctrl.setRefIhm(ihm);
        ctrl.setRefWrk(wrk);
        ihm.setRefCtrl(ctrl);
        wrk.setRefCtrl(ctrl);
        ctrl.start();
        
    }
   
    
    
}

package Wrk;

import com.phidget22.LCD;

/**
 * @author GamezJ
 * @version 1.0
 *
 */
public class WrkPhidget extends Thread {

    private int ID;
    private LCD lcd;

    public WrkPhidget() {

    }


    /**
     *
     * @param string
     */
    public void afficher(String string) {
        try {
            lcd.clear();
            lcd.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, string);
            lcd.flush();
        } catch (Exception e) {
        }

    }

    /**
     *
     * @param string
     */
    public boolean initialise(String string) {
        boolean retour = false;
        try {
            lcd = new LCD();
            lcd.setDeviceSerialNumber(Integer.parseInt(string));
            lcd.open(5000);
            lcd.writeText(com.phidget22.LCDFont.DIMENSIONS_5X8, 0, 0, "En attente de connexion");
            lcd.setBacklight(0.3);
            lcd.flush();
            retour = true;
        } catch (Exception e) {

        }

        return retour;
    }
}//end WrkPhidget

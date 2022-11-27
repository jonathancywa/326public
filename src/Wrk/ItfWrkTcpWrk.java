package Wrk;

import beans.User;
import java.util.List;



/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public interface ItfWrkTcpWrk {

	/**
	 * 
	 * @param string
	 */
	public void ajouterUser(String[] string);

	/**
	 * 
	 * @param string
     * @return list des utilisateur
	 */
	public List<User> lireUser();

	/**
	 * 
	 * @param string
	 */
	public void setMouvement(String[] string);

	/**
	 * 
	 * @param string
	 */
	public void supprimerUser(String[] string);

}
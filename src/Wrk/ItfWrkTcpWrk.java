package Wrk;

import beans.User;
import java.util.List;



/**
 * @author GamezJ
 * @version 1.0
 * 
 */
public interface ItfWrkTcpWrk {

	/**
	 * 
	 * @param user
	 */
	public void ajouterUser(User user);

	/**
	 * 
	 * 
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
	 * @param user
	 */
	public void supprimerUser(User user);

}
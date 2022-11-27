package Ihm;

import beans.User;
import java.util.List;


/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public interface CtrlIhmGestionUser {

	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public void addUser(String nom, String prenom);

	/**
	 * 
	 * @param user
	 */
	public void deleteUser(User user);

	public void getUser();

}
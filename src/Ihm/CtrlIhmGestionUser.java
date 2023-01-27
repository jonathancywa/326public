package Ihm;

import beans.User;
import java.util.List;


/**
 * interface contrôleur de l'ihm des utilisateur
 * @author GamezJ
 * @version 1.0
 * 
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
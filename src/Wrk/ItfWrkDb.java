/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Wrk;

import beans.User;
import java.util.List;

/**
 *
 * @author Gamezj
 */
public interface ItfWrkDb {


	/**
	 * 
	 * @param user
	 */
	public void creerModifierUser(User user);

	/**
	 * 
	 * @param string
	 */
	public void lire(String string);

	public List<User> lireDb();

	/**
	 * 
	 * @param user
	 */
	public void supprimerUser(User user);

}   


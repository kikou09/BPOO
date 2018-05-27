package capacite ;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;

/**
* Une capacité, c'est l'abstraction générique pour décrire, le pouvoir du héros,
* le sort d'une carte Sort, la capacité d'un serviteur, etc.
* @author Claire MICHALON , Jorane SCHUSTER
* 
*/
public abstract interface ICapacite{
	
	/**
	 * Certaines capacité agissent quand on le demande, et éventuellement sur une cible...
	 * @param cible
	 * @throws HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 * 							-si la cible est nulle
	 */
	public abstract void executerAction(Object cible)  throws HearthstoneException ; 
	
	
	
	/**
	  * Certaines capacité agissent en début de tour 
	 * @throws HearthstoneException:
	 *  * 					- selon les cas :
	 * 							-si la capacite est nulle
	 */
	public abstract void executerEffetDebutTour() throws HearthstoneException ; 
	
	
	/**
	* Certaines capacité agissent lorsque la carte disparaît du jeu
	 * @param cible
	 * @throws HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 * 							-si la cible est nulle
	 */
	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException; 
	
	/**
	 * Certaines capacité agissent en fin de tour
	 * @throws HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 * 		
	 */
	public abstract void executerEffetFinTour() throws HearthstoneException ; 
	
	/**
	 * Certaines capacité agissent en début de mise en jeu
	 * @throws HearthstoneCapaciteException : -si la cible est nulle MAIS necessaire
	 * 		   HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 */
	public abstract void executerEffetMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException;
	
	/**
	 * getteur de base de la description
	 * @return string de la description
	 */
	public abstract String getDescription();
	
	/**
	 * getteur de base du nom
	 * @return string du nom
	 */
	public abstract String getNom();



	public abstract boolean getUtilise();

}

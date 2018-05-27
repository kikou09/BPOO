package capacite ;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;

/**
* Une capacit�, c'est l'abstraction g�n�rique pour d�crire, le pouvoir du h�ros,
* le sort d'une carte Sort, la capacit� d'un serviteur, etc.
* @author Claire MICHALON , Jorane SCHUSTER
* 
*/
public abstract interface ICapacite{
	
	/**
	 * Certaines capacit� agissent quand on le demande, et �ventuellement sur une cible...
	 * @param cible
	 * @throws HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 * 							-si la cible est nulle
	 */
	public abstract void executerAction(Object cible)  throws HearthstoneException ; 
	
	
	
	/**
	  * Certaines capacit� agissent en d�but de tour 
	 * @throws HearthstoneException:
	 *  * 					- selon les cas :
	 * 							-si la capacite est nulle
	 */
	public abstract void executerEffetDebutTour() throws HearthstoneException ; 
	
	
	/**
	* Certaines capacit� agissent lorsque la carte dispara�t du jeu
	 * @param cible
	 * @throws HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 * 							-si la cible est nulle
	 */
	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException; 
	
	/**
	 * Certaines capacit� agissent en fin de tour
	 * @throws HearthstoneException:
	 * 					- selon les cas :
	 * 							-si la capacite est nulle
	 * 		
	 */
	public abstract void executerEffetFinTour() throws HearthstoneException ; 
	
	/**
	 * Certaines capacit� agissent en d�but de mise en jeu
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

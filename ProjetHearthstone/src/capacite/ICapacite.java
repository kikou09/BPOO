package capacite ;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;

/**
* Une capacit�, c'est l'abstraction g�n�rique pour d�crire, le pouvoir du h�ros,
* le sort d'une carte Sort, la capacit� d'un serviteur, etc.
*
*/
public abstract interface ICapacite{
	public abstract void executerAction(Object cible)  throws HearthstoneException ; 
	public abstract void executerEffetDebutTour() throws HearthstoneException ; 
	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException; 
	public abstract void executerEffetFinTour() throws HearthstoneException ; 
	public abstract void executerEffetMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException;
	public abstract String getDescription();
	public abstract String getNom();

}

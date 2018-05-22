package capacite ;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;

/**
* Une capacité, c'est l'abstraction générique pour décrire, le pouvoir du héros,
* le sort d'une carte Sort, la capacité d'un serviteur, etc.
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

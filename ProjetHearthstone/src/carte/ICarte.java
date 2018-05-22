package carte;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import capacite.ICapacite;
import joueur.IJoueur;

/**
 * Une carte, ben c'est une carte du jeu quoi ! Une carte peut être une carte de sort 
 * ou une carte serviteur (on ne s'occupe pas des autres sortes de cartes).
 *
 */
public abstract interface ICarte extends Cloneable{

	public abstract boolean	disparait();
	public abstract void executerAction(Object cible) throws HearthstoneException;
	public abstract void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException;
	public abstract void executerEffetDebutTour() throws HearthstoneException ; 
	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException ; 
	public abstract void executerEffetFinTour() throws HearthstoneException ; 
	public abstract int	getCout() ;
	public abstract  String	getNom() ;
	public abstract int getMana();
	public abstract IJoueur	getProprietaire() ;
	public abstract ICapacite getCapacite();
}
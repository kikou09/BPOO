package carte;

import application.HearthstoneException;
import joueur.IJoueur;
import joueur.Joueur;

public abstract interface ICarte extends Cloneable{

	public abstract boolean	disparait();
	public abstract void executerAction(Object cible) throws HearthstoneException;
	public abstract void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException;
	public abstract void executerEffetDebutTour() ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetDisparition(Object cible) ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetFinTour() ; //throws jeu.ExceptionHearthstone;
	public abstract int	getCout() ;
	public abstract  String	getNom() ;
	public abstract int getMana();
	public abstract IJoueur	getProprietaire() ;
}
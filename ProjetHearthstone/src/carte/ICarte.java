package carte;

import joueur.Joueur;

public abstract interface ICarte extends Cloneable{

	public abstract boolean	disparait();
	public abstract void executerAction(Object cible) ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetDebutMiseEnJeu(Object cible) ; // throws jeu.ExceptionHearthstone;
	public abstract void executerEffetDebutTour(Object cible) ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetDisparition(Object cible) ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetFinTour() ; //throws jeu.ExceptionHearthstone;
	public abstract int	getCout() ;
	public abstract  String	getNom() ;
	public abstract Joueur	getProprietaire() ;
}
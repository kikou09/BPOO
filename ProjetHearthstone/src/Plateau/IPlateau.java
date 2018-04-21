package Plateau;

import application.HearthstoneException;
import joueur.IJoueur;

public abstract interface IPlateau {

	public abstract void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
	public abstract void demarrerPartie() throws HearthstoneException;
	public abstract boolean	estDemarree();
	public abstract void finTour(IJoueur joueur) throws HearthstoneException;
	public abstract void gagnePartie(IJoueur joueur);
	public abstract IJoueur	getAdversaire(IJoueur joueur) throws HearthstoneException;
	public abstract IJoueur	getJoueurCourant();
	public abstract void setJoueurCourant(IJoueur joueur);

}



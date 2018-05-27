package carte;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import capacite.ICapacite;
import joueur.IJoueur;

/**
 * Une carte, ben c'est une carte du jeu quoi ! Une carte peut être une carte de sort 
 * ou une carte serviteur (on ne s'occupe pas des autres sortes de cartes).
 *@author Jorane SCHUSTER , Claire MICHALON
 */
public abstract interface ICarte extends Cloneable{
	
	/**
	 * Fonction qui teste si les conditions pour que la carte soit encore présente
	 * au tour suivant.
	 * @return un booleen . Vrai si la carte doit disparaitre du plateau
	 */
	public abstract boolean	disparait();
	
	/**
	 * Une carte peut avoir une action qui se commande à n'importe quel moment du tour 
	 * lorsqu'elle est en jeu
	 * @param cible
	 * @throws HearthstoneException selon les cas si c'est un serviteur ou un sort
	 */
	public abstract void executerAction(Object cible) throws HearthstoneException;
	
	
	/**
	 * Une carte peut avoir un effet au début de sa mise en jeu
	 * @param cible
	 * @throws HearthstoneException : 
	 * 					- si la capacite a deja été utilise
	 * @throws HearthstoneCapaciteException :
	 * 					- si la capacite a besoin d'une cible mais qu'elle est nulle
	 */
	public abstract void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException;
	
	
	/**
	 * Une carte peut avoir un effet au début de chaque tour où elle est en jeu
	 * @throws HearthstoneException
	 */
	public abstract void executerEffetDebutTour() throws HearthstoneException ; 
	
	/**
	 * Une carte peut avoir un effet au moment de sa disparition du jeu
	 * @param cible
	 * @throws HearthstoneException
	 */
	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException ; 
	
	/**
	 * Une carte peut avoir un effet à la fin d'un chaque tour où elle est en jeu
	 * @throws HearthstoneException
	 */
	public abstract void executerEffetFinTour() throws HearthstoneException ; 
	
	/**
	 * Getter pour le cout en mana de la carte
	 * @return un entier qui est le cout
	 */
	public abstract int	getCout() ;
	
	/**
	 * Getter pour le nom de la carte
	 * @return string du nom
	 */
	public abstract  String	getNom() ;
	
	/**
	 * Getter pour le proprietaire de la carte 
	 * @return joueur proprietaire
	 */
	public abstract IJoueur	getProprietaire() ;
	
	/**
	 * Getter pour connaittre la capacite de la carte
	 * @return capacite
	 */
	public abstract ICapacite getCapacite();
	
}
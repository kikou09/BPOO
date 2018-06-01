package Plateau;

import application.HearthstoneException;
import joueur.IJoueur;

/**
 * Le plateau gère toute la partie, notamment le début et la fin de partie. 
 * Il n'y a qu'un seul plateau en tout et pour tout. 
 * @author Jorane SCHUSTER , Claire MICHALON
 */
public abstract interface IPlateau {

	/**
	 * Ajoute un joueur a la partie
	 * @param joueur : joueur a ajouter dans le jeu
	 * @throws HearthstoneException : 
	 * 				- si la partie a deja demarree
	 * 				- si le joueur est deja presents dans la partie
	 * 				- si la partie est complète
	 */
	public abstract void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
	
	
	/**
	 * cette jolie fonction sans parametre demarre la partie 
	 * @throws HearthstoneException :
	 * 				- si la partie est deja demaree
	 * 				- si la partie n'est pas complète (moins de 2 joueurs)
	 */
	public abstract void demarrerPartie() throws HearthstoneException;
	
	
	/**
	 * Retourne vrai si la partie est demarree
	 * @return booleen 
	 */
	public abstract boolean	estDemarree();
	
	
	/**
	 * Le joueur decide de finir son tour .
	 * @param joueur : joueur qui finit son tour
	 * @throws HearthstoneException :
	 * 				- si la partie n'est pas demarree
	 * 				- si le joueur n'a pas le tour 
	 */
	public abstract void finTour(IJoueur joueur) throws HearthstoneException;
	
	
	/**
	 * Le joueur gagne la partie et donc le heros du joueur adverse est mort .
	 * @param joueur : joueur qui gagne la partie
	 * @throws HearthstoneException :
	 * 				- si la partie n'est pas demarree
	 */
	public abstract void gagnePartie(IJoueur joueur) throws HearthstoneException;
	
	
	
	/**
	 * Renvoie l'adversaire 
	 * @param joueur : joueur dont on veut l'adversaire 
	 * @return l'adversaire 
	 * @throws HearthstoneException : 
	 * 				- si la partie n'a pas demarree
	 * 				- si joueur est null
	 * 				- si joueur n'est pas dans la partie 
	 */
	public abstract IJoueur	getAdversaire(IJoueur joueur) throws HearthstoneException;
	
	
	/**
	 * 
	 * @return renvoie le joueur qui doit jouer à ce tour 
	 */
	public abstract IJoueur	getJoueurCourant();
	
	
	/**
	 * Setter qui va ave le getter 
	 * @param joueur  joueur qui devient le joueur courant
	 * @throws HearthstoneException : 
	 * 			- si joueur est null
	 * 			- si joueur n'est pas dans la partie 
	 */
	public abstract void setJoueurCourant(IJoueur joueur) throws HearthstoneException;

}



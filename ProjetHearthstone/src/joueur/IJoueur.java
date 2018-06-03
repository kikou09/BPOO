package joueur;

import java.util.ArrayList;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import carte.ICarte;


/**
 * Cette interface définit le comportement (normalement) minimal d'un joueur
 * @author Claire MICHALON , Jorane SCHUSTER
 *
 */
public abstract interface IJoueur{

	/**
	 * Nombre max de mana que le joueur peut avoir (10 en principe)
	 */
	public static int MAX_MANA=10;
	/**
	 * Le nombre max de cartes qui peuvent composer un deck.
	 */
	public static int TAILLE_DECK=15;
	
	
	/**
	 * Il se passe beaucoup de choses au moment où le joueur finit le tour.
	 * @throws HearthstoneException : si ce n'est pas le tour du joueur
	 */
	public abstract void finirTour()  throws HearthstoneException;
	
	/**
	 * Permet de rechercher une carte en jeu par rapport à un bout de son nom 
	 * (grâce à la fonction contains de la classe String).
	 * @param nom de la carte demandee
	 * @return carte
	 */
	public abstract ICarte getCarteEnJeu(String nom);
	
	/**
	 * Permet de rechercher une carte de la main par rapport à un bout de son nom 
	 * (grâce à la fonction contains de la classe String).
	 * @param nom de la carte demandee
	 * @return carte
	 */
	public abstract ICarte getCarteEnMain(String nom);
	
	/**
	 * getteur du heros
	 * @return heros du joueur
	 */
	public abstract heros.Heros getHeros();
	
	/**
	 * c'est un getteur.
	 * @return deck sous forme d' ArrayList 
	 */
	public abstract ArrayList<ICarte> getDeck();
	
	/**
	 * c'est un getteur
	 * @return main sous forme d' ArrayList
	 */
	public abstract ArrayList<ICarte> getMain();
	
	/**
	 * c'est un getteur
	 * @return les cartes posées  sous forme d' ArrayList
	 */
	public abstract ArrayList<ICarte> getCartes_Poses();
	
	/**
	 * c'est un setteur
	 * @param d = deck affecté
	 * @throws HearthstoneException : -si d est null 
	 * 								  - si la partie est en cours
	 */
	public abstract void setDeck(ArrayList<ICarte> d) throws HearthstoneException;
	
	/**
	 * c'est un getteur
	 * @return le mana du joueur
	 */
	public abstract int getMana();
	
	/**
	 * c'est. un. getteur.
	 * @return le pseudo du joueur
	 */
	public abstract String getPseudo();
	
	/**
	 * devinez.
	 * @return le stock de mana du joueur
	 */
	public abstract int getStockMana();
	
	/**
	 * Pendant le tour, un joueur peut tenter de prendre une carte de sa main
	 *  et de la placer sur le board.
	 * @param carte carte a jouer 
	 * @throws HearthstoneException si cette carte n'est pas dans la main du joueur
	 * 								si il n'y a pas assez de mana pour invouer cette carte
	 * @throws HearthstoneCapaciteException si capacite.executerEffeMiseEnJeu a
	 *  besoin d'une cible
	 */
	public abstract void jouerCarte(ICarte carte) throws HearthstoneException , HearthstoneCapaciteException ;
	
	/**
	 * Pendant le tour, un joueur peut tenter de prendre une carte de sa main
	 *  et de la placer sur le board. 
	 * @param carte carte a jouer
	 * @param cible cible de la carte
	 * @throws HearthstoneException  si cette carte n'est pas dans la main du joueur
	 * 								si il n'y a pas assez de mana pour invouer cette carte
	 * @throws HearthstoneCapaciteException si capacite.executerEffeMiseEnJeu a besoin d'une cible
	 *  
	 */
	public abstract void jouerCarte(ICarte carte, Object cible) throws HearthstoneException, HearthstoneCapaciteException;
	
	/**
	 * Lorsqu'une carte a fini sa vie (un serviteur qui meut, un sort qui vient d'être utilisé,
	 *  ...), il faut gérer le jeu (une carte en moins...), 
	 *  ainsi que les effets liés à la disparition de la carte (Rale d'agonie par exemple).
	 * @param carte carte qui est perdue
	 * @throws HearthstoneException si la carte n'a pas ete posee sur le plateau
	 */
	public abstract void perdreCarte(ICarte carte) throws HearthstoneException ;
	
	/**
	 * Au début de chaque tour, une carte du deck est choisie aléatoirement 
	 * et est placée dans la main du joueur.
	 * @throws HearthstoneException si la pioche est vide
	 */
	public abstract void piocher() ;
	
	/**
	 * Il se passe beaucoup de choses au moment où le joueur prend le tour.
	 * @throws HearthstoneException si le tour du joueur est en cours
	 */
	public abstract void prendreTour()  throws HearthstoneException ;
	
	/**
	 * Lorsque qu'une carte est en jeu, le joueur peut utiliser cette carte.
	 * @param carte carte a utiliser
	 * @param cible cible de la carte utilisée
	 * @throws HearthstoneException  si cette carte n'est pas sur le plateau
	 */
	public abstract void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
	
	/**
	 * Cette fonction utilise le pouvoir du héros du joueur
	 *  pour faire quelque chose sur la cible.
	 * @param cible cible du pouvoir du hero
	 * @throws HearthstoneException si le heros ne possede pas de pouvoir
	 * @throws HearthstoneCapaciteException si la cible est null
	 */
	public abstract void utiliserPouvoir(Object cible) throws HearthstoneException, HearthstoneCapaciteException ;
	
	/**
	 * Surprise! c'est un setteur
	 * @param i qui est affecte au mana
	 */
	public abstract void setMana(int i);
}



package joueur;

import java.util.ArrayList;

import application.HearthstoneException;
import carte.Carte;
import carte.ICarte;

public abstract interface IJoueur{

	public static int MAX_MANA=10;
	public static int TAILLE_DECK=15;
	
	public abstract void finirTour()  throws HearthstoneException;
	public abstract ICarte getCarteEnJeu(String nom);
	public abstract ICarte getCarteEnMain(String nom);
	public abstract heros.Heros getHeros();
	public abstract ArrayList<ICarte> getDeck();
	public abstract ArrayList<ICarte> getMain();
	public abstract ArrayList<ICarte> getCartes_Poses();
	public abstract void setDeck(ArrayList<ICarte> d) throws HearthstoneException;
	public abstract int getMana();
	public abstract String getPseudo();
	public abstract int getStockMana();
	public abstract void jouerCarte(ICarte carte) throws HearthstoneException ;
	public abstract void jouerCarte(ICarte carte, Object cible) throws HearthstoneException;
	public abstract void perdreCarte(ICarte carte) throws HearthstoneException ;
	public abstract void piocher() throws HearthstoneException ;
	public abstract void prendreTour()  throws HearthstoneException ;
	public abstract void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
	public abstract void utiliserPouvoir(Object cible) throws HearthstoneException ;
	public abstract void setMana(int i);
}



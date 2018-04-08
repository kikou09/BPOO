package joueur;

import java.util.ArrayList;

import carte.Carte;

public abstract interface IJoueur{

	
	public abstract void finirTour() ;//throws jeu.ExceptionHearthstone;
	//public abstract ICarte getCarteEnJeu();
	//public abstract ICarte getCarteEnMain();
	public abstract heros.Heros getHeros();
	public abstract ArrayList<Carte> getDeck();
	public abstract ArrayList<Carte> getMain();
	public abstract int getMana();
	public abstract String getPseudo();
	public abstract int getStockMana();
	//public abstract void jouerCarte(ICarte carte)throws jeu.ExceptionHearthstone;
	//public abstract void jouerCarte(ICarte carte, java.lang.Object cible) throws jeu.ExceptionHearthstone;
	//public abstract void perdreCarte(ICarte carte)throws jeu.ExceptionHearthstone ;
	public abstract void piocher(); //throws jeu.ExceptionHearthstone;
	public abstract void prendreTour(); //throws jeu.ExceptionHearthstone;
	//public abstract void utiliserCarte(ICarte carte, java.lang.Object cible)throws jeu.ExceptionHearthstone;
	public abstract void utiliserPouvoir(java.lang.Object cible) ; //throws jeu.ExceptionHearthstone;
}



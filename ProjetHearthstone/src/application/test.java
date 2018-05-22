package application;

import java.util.ArrayList;

import Plateau.Plateau;
import capacite.AttaqueCiblee;
import capacite.Pioche;
import carte.ICarte;
import carte.Serviteur;
import heros.Heros;
import joueur.IJoueur;
import joueur.Joueur;

public class test {
	
public static void main(String[] args) throws HearthstoneException, HearthstoneCapaciteException {
		
		
		/*Premier joueur avec le heros Rexxar*/
		Heros Rexxar=new Heros("Rexxar" , new AttaqueCiblee ("Tir assuré ",
				"Inflige 2 points de degats à la cible", 2));
		IJoueur joueur1=new Joueur("Joueur 1 " , Rexxar);
		joueur1.getHeros().setCartes(Hearthstone.CreerCartesRexxar(joueur1));
		
		/*Deuxieme joueur avec le heros Jaina*/
		IJoueur joueur2=new Joueur ( "Joueur 2" , new Heros("Jaina",new AttaqueCiblee("Boule de feu",
				"Inflige 1 point de degat à la cible", 1)));
		joueur2.getHeros().setCartes(Hearthstone.CreerCartesJaina(joueur2));
		
		//Deck du joueur 1
		ArrayList<ICarte> deck_j1=Hearthstone.CreerCartesNeutres(joueur1);
		try {
			joueur1.setDeck(deck_j1);
		}
		catch(HearthstoneException e) {
			e.printStackTrace();
		}
		joueur1.getDeck().addAll(joueur1.getHeros().getCartes());
		
		//Deck du joueur 2
		ArrayList<ICarte> deck_j2=Hearthstone.CreerCartesNeutres(joueur2);
		deck_j2.addAll(joueur2.getHeros().getCartes());
		
		joueur1.setDeck(deck_j1);
		joueur2.setDeck(deck_j2);
		
		Plateau.instancePlateau().ajouterJoueur(joueur1);
		Plateau.instancePlateau().ajouterJoueur(joueur2);
		Plateau.instancePlateau().demarrerPartie();
		Plateau.instancePlateau().setJoueurCourant(joueur1);

	
		ICarte busard = new Serviteur("Busard affamé", 5, joueur1, 3, 2, new Pioche(1) );
		busard.executerEffetDebutMiseEnJeu(null);
		System.out.println(joueur1.getMain());
		


}
}

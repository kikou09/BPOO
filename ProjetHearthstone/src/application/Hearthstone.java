package application;

import java.util.ArrayList;

import Plateau.Plateau;
import carte.Carte;
import carte.Serviteur;
import carte.Sort;
import joueur.Joueur;
import heros.Heros;

public class Hearthstone {

	public static void main(String[] args) {
		Plateau plateau=new Plateau ();
		
		ArrayList<Carte> d =new ArrayList<Carte>();
		
		
		//Heros Rexxar= Heros.choixHeros("Rexxar");
		Heros Rexxar=new Heros("Rexxar");
		Heros Jaina= new Heros("Jaina");				
		Joueur j = new Joueur("Coucou",Rexxar);
		Joueur j2 = new Joueur("Ja", Jaina);
		plateau.ajouterJoueur(j);
		plateau.ajouterJoueur(j2);
		plateau.demarrerPartie();
		plateau.setJoueurCourant(j);
	    
		
		Serviteur s1=new Serviteur("Servi", 2 , j2,3,4);
		Serviteur s2=new Serviteur("Servi2", 1 , j2,2,3);
		Serviteur s3 = new Serviteur("Servi3", 2 , j2,5,6);
		d.add(s1);
		d.add(s2);
		d.add(s3);
		j2.setDeck(d);
		j2.piocher();
		System.out.println(j2.getMain());
	}

}

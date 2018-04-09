package application;

import java.util.ArrayList;


import Plateau.Plateau;
import carte.Carte;
import carte.Serviteur;
import carte.Sort;
import joueur.Joueur;
import heros.Heros;
import capacite.Capacite;
import capacite.Charge;
import capacite.Chasseur;
import capacite.ImageMirroir;
import capacite.Invocation;
import capacite.LachezChiens;
import capacite.Pioche;
import capacite.Provocation;
public class Hearthstone {
		
	public ArrayList<Carte> CreerCartesJaina(Joueur j)
	{
		ArrayList<Carte> CartesJaina = new ArrayList<Carte> ();
		Sort flamme =new Sort("Choc de Flamme ", 7 , j ,new Capacite("Attaque massive","inflige 4 pts de dégats a tous les serviteurs adverses ", 4));
		CartesJaina.add(flamme);
		Sort givre = new Sort ("Eclair de givre", 2, j, new Capacite("Attaque de givre", "inflige 3 pts de dégats aux personnages cibles", 3));
		CartesJaina.add(givre);
		Sort arcanes = new Sort ("Intelignece des arcanes", 2, j, new Pioche(2));
		CartesJaina.add(arcanes);
		Sort mirroir = new Sort ("Image mirroir", 1, j, new ImageMirroir());
		CartesJaina.add(mirroir);
		Sort explosion = new Sort ("Explosion Pyrotechnique", 10, j, new Capacite("Explosion Pyrotechnique", "inflige 10 pts de dégats a tous les serviteurs adverses", 10));
		CartesJaina.add(explosion);
		
		return CartesJaina;
		
	}
	
	public ArrayList<Carte> CreerCartesRexxar(Joueur j)
	{
		ArrayList<Carte> CartesRexxar = new ArrayList<Carte> ();
		Sort chasseur = new Sort ("Marque du Chasseur", 1, j, new Chasseur());
		CartesRexxar.add(chasseur);
		Sort tirarcanes = new Sort ("Tir des arcanes", 1, j, new Capacite("Tir des arcanes", "inflige 2 pts de dégats au personnage cible", 2));
		CartesRexxar.add(tirarcanes);
		Sort chiens = new Sort ("Lachez les chiens", 3, j, new LachezChiens()); 
		CartesRexxar.add(chiens);
		Sort tuer = new Sort ("Ordre de tuer", 3, j, new Capacite("Ordre de tuer", "Inflige 3 pts de degats au personnage cible", 3)); 
		CartesRexxar.add(tuer);
		Serviteur busard = new Serviteur("Busard affamé", 5, j, 3, 2, new Pioche(1) );
		CartesRexxar.add(busard);
		
		return CartesRexxar;
		
	}
	
	public ArrayList<Carte> CreerCartesNeutres(Joueur proprietaire)
	{
		ArrayList<Carte> CartesNeutres = new ArrayList<Carte> ();
		Serviteur chasse_marree=new Serviteur ("Chasse maréé murloc" , 2, proprietaire , 2 , 1 , new Invocation ("Cri de guerre" , "Invocation d'un serviteur 1/1" , new Serviteur ("Serviteur de Chasse-maree" , 0 , proprietaire , 1, 1,null)));
		CartesNeutres.add(chasse_marree);
		
		Serviteur Champion_hurlevent= new Serviteur ("Champion de Hurlevent" , 7 , proprietaire ,  6 ,6 , new Capacite ( " Bonus de hurlevent " , "Effet sur les serviteurs donnant un bonus +1/+1 " , 1)); //????
		
		Serviteur Chef_raid = new Serviteur ("Chef de Raid" , 3 , proprietaire , 2 , 2 , new Capacite ( " Bonus du chef de raid " , " Effet sur les serviteurs alliés donnant un bonus +1/0" , 1  )); // ????? 
		
		Serviteur missiliere= new Serviteur ("La missilière témeraire " , 6 , proprietaire , 5 ,  2 , new Charge ());
		CartesNeutres.add(missiliere);
		
		Serviteur ogre_magi= new Serviteur ( "L'ogre-magi" , 4 , proprietaire , 4 , 4 , new Provocation ());
		CartesNeutres.add(ogre_magi);
		
		Serviteur archimage = new Serviteur ("Archimage" , 6 , proprietaire , 4 ,7 , new Provocation());
		CartesNeutres.add(archimage);
		
		Serviteur gnome = new Serviteur ("Gnôme lépreux " , 1 ,proprietaire , 1 , 1 , new Capacite ( " Attaque du lépreux " , "Inflige 2 points de dégats au héros " , 2 ));
		CartesNeutres.add(gnome);
		
		Serviteur golem = new Serviteur ( " Golem des moissons" , 3 , proprietaire , 2 , 3 , new Invocation ( "Golemisation " , " Invoque un Golem endomage 2/1" , new Serviteur ( " Serviteur de Golem " , 0 , proprietaire , 2 , 1 ,null)));
		CartesNeutres.add(golem);
		
		Sort charge = new Sort("Charge" , 1 , proprietaire , new Charge());
		CartesNeutres.add(charge);
		
		Sort attaque_mentale= new Sort ( " Attaque mentale " , 2 ,  proprietaire , new Capacite ( "Attaque mentale " , "Inflige 5 points de dégats au héros " , 5));
		CartesNeutres.add(attaque_mentale);
		
		return CartesNeutres;
		
		
	}

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
	    
		
		//Serviteur s1=new Serviteur("Servi", 2 , j2,3,4);
		//Serviteur s2=new Serviteur("Servi2", 1 , j2,2,3);
		//Serviteur s3 = new Serviteur("Servi3", 2 , j2,5,6);
		//d.add(s1);
		//d.add(s2);
		//d.add(s3);
		j2.setDeck(d);
		j2.piocher();
		System.out.println(j2.getMain());
	}

}

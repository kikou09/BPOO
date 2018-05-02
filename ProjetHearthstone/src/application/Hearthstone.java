package application;

import java.util.ArrayList;

import Plateau.IPlateau;
import Plateau.Plateau;
import carte.Carte;
import carte.ICarte;
import carte.Serviteur;
import carte.Sort;
import cor.Console;
import cor.Interface;
import cor.InterfaceCharge;
import cor.InterfaceExecuterAction;
import cor.InterfaceFinirTour;
import cor.InterfaceJouerCarteJeu;
import cor.InterfaceJouerCarteMain;
import cor.InterfaceJouerSort;
import cor.InterfaceQuitter;
import cor.InterfaceUtiliserPouvoir;
import joueur.IJoueur;
import joueur.Joueur;
import heros.Heros;
import capacite.ICapacite;
import capacite.AttaqueCiblee;
import capacite.AttaqueDuHeros;
import capacite.AttaqueMassive;
import capacite.AttaqueTotale;
import capacite.Capacite;
import capacite.Charge;
import capacite.Chasseur;
import capacite.EffetPermanent;
import capacite.ImageMirroir;
import capacite.Invocation;
import capacite.LachezChiens;
import capacite.Pioche;
import capacite.Provocation;
public class Hearthstone {
	
	public static	Interface ihm=null;
	public final static Console es=new Console();
		
	public static ArrayList<ICarte> CreerCartesJaina(IJoueur j)
	{
		ArrayList<ICarte> cartesJaina = new ArrayList<ICarte> ();
		ICarte flamme =new Sort("Choc de Flamme ", 7 , j ,new AttaqueMassive("Attaque massive","inflige 4 pts de dégats a tous les serviteurs adverses ", 4));
		cartesJaina.add(flamme);
		ICarte givre = new Sort ("Eclair de givre", 2, j, new AttaqueCiblee("Attaque de givre", "inflige 3 pts de dégats au personnages cible", 3));
		cartesJaina.add(givre);
		ICarte arcanes = new Sort ("Intelligence des arcanes", 2, j, new Pioche(2));
		cartesJaina.add(arcanes);
		ICarte mirroir = new Sort ("Image mirroir", 1, j, new ImageMirroir());
		cartesJaina.add(mirroir);
		ICarte explosion = new Sort ("Explosion Pyrotechnique", 10, j, new AttaqueTotale("Explosion Pyrotechnique", "inflige 10 pts de dégats a tous les serviteurs adverses", 10));
		cartesJaina.add(explosion);
		
		return cartesJaina;
		
	}
	
	public static ArrayList<ICarte> CreerCartesRexxar(IJoueur j)
	{
		ArrayList<ICarte> cartesRexxar = new ArrayList<ICarte> ();
		ICarte chasseur = new Sort ("Marque du Chasseur", 1, j, new Chasseur());
		cartesRexxar.add(chasseur);
		ICarte tirarcanes = new Sort ("Tir des arcanes", 1, j, new AttaqueCiblee("Tir des arcanes", "inflige 2 pts de dégats au personnage cible", 2));
		cartesRexxar.add(tirarcanes);
		ICarte chiens = new Sort ("Lachez les chiens", 3, j, new LachezChiens()); 
		cartesRexxar.add(chiens);
		ICarte tuer = new Sort ("Ordre de tuer", 3, j, new AttaqueCiblee("Ordre de tuer", "Inflige 3 pts de degats au personnage cible", 3)); 
		cartesRexxar.add(tuer);
		ICarte busard = new Serviteur("Busard affamé", 5, j, 3, 2, new Pioche(1) );
		cartesRexxar.add(busard);
		
		return cartesRexxar;
		
	}
	
	public static ArrayList<ICarte> CreerCartesNeutres(IJoueur proprietaire)
	{
		ArrayList<ICarte> cartesNeutres = new ArrayList<ICarte> ();
		ICarte chasse_marree=new Serviteur ("Chasse marée murloc" , 2, proprietaire , 2 , 1 , new Invocation ("Cri de guerre" , "Invocation d'un serviteur 1/1" , new Serviteur ("Serviteur de Chasse-maree" , 0 , proprietaire , 1, 1,null)));
		cartesNeutres.add(chasse_marree);
		
		ICarte champion_hurlevent= new Serviteur ("Champion de Hurlevent" , 7 , proprietaire ,  6 ,6 , new EffetPermanent ( " Bonus de hurlevent " , "Effet sur les serviteurs donnant un bonus +1/+1 " , 1 , 1));
		cartesNeutres.add(champion_hurlevent);
		
		ICarte chef_raid = new Serviteur ("Chef de Raid" , 3 , proprietaire , 2 , 2 , new EffetPermanent ( " Bonus du chef de raid " , " Effet sur les serviteurs alliés donnant un bonus +1/0" , 1 , 0 ));  
		cartesNeutres.add(chef_raid);
		
		ICarte missiliere= new Serviteur ("La missilière témeraire " , 6 , proprietaire , 5 ,  2 , new Charge ());
		cartesNeutres.add(missiliere);
		
		ICarte ogre_magi= new Serviteur ( "L'ogre-magi" , 4 , proprietaire , 4 , 4 , new Provocation ());
		cartesNeutres.add(ogre_magi);
		
		ICarte archimage = new Serviteur ("Archimage" , 6 , proprietaire , 4 ,7 , new Provocation());
		cartesNeutres.add(archimage);
		
		ICarte gnome = new Serviteur ("Gnôme lépreux " , 1 ,proprietaire , 1 , 1 , new AttaqueDuHeros ( " Attaque du lépreux " , "Inflige 2 points de dégats au héros " , 2 ));
		cartesNeutres.add(gnome);
		
		ICarte golem = new Serviteur ( " Golem des moissons" , 3 , proprietaire , 2 , 3 , new Invocation ( "Golemisation " , " Invoque un Golem endomage 2/1" , new Serviteur ( " Serviteur de Golem " , 0 , proprietaire , 2 , 1 ,null)));
		cartesNeutres.add(golem);
		
		ICarte charge = new Sort("Charge" , 1 , proprietaire , new Charge());
		cartesNeutres.add(charge);
		
		ICarte attaque_mentale= new Sort ( " Attaque mentale " , 2 ,  proprietaire , new AttaqueDuHeros ( "Attaque mentale " , "Inflige 5 points de dégats au héros " , 5));
		cartesNeutres.add(attaque_mentale);
		
		return cartesNeutres;
		
		
	}

	public static void main(String[] args) {
		
		ihm=initialiserInterface();
		
		if(ihm==null){
			es.println("L'application ne fait rien ");
			System.exit(0);
		}	
		
		/*Premier joueur avec le heros Rexxar*/
		Heros Rexxar=new Heros("Rexxar" , new AttaqueCiblee ("Tir assuré ",
				"Inflige 2 points de degats à la cible", 2));
		IJoueur joueur1=new Joueur("Joueur 1 " , Rexxar);
		joueur1.getHeros().setCartes(CreerCartesRexxar(joueur1));
		
		/*Deuxieme joueur avec le heros Jaina*/
		IJoueur joueur2=new Joueur ( "Joueur 2" , new Heros("Jaina",new AttaqueCiblee("Boule de feu",
				"Inflige 1 point de degat à la cible", 1)));
		joueur2.getHeros().setCartes(CreerCartesJaina(joueur2));
		
		//Deck du joueur 1
		ArrayList<ICarte> deck_j1=CreerCartesNeutres(joueur1);
		try {
			joueur1.setDeck(deck_j1);
		}
		catch(HearthstoneException e) {
			e.printStackTrace();
		}
		joueur1.getDeck().addAll(joueur1.getHeros().getCartes());
		
		//Deck du joueur 2
		ArrayList<ICarte> deck_j2=CreerCartesNeutres(joueur2);
		deck_j2.addAll(joueur2.getHeros().getCartes());
		try{
			joueur2.setDeck(deck_j2);
		}
		catch(HearthstoneException e) {
			e.printStackTrace();
		}	

		try {
				Plateau.instancePlateau().ajouterJoueur(joueur1);
				Plateau.instancePlateau().ajouterJoueur(joueur2);
		}
		catch (HearthstoneException e) {
			
			e.printStackTrace();
		}
		
		try {
				Plateau.instancePlateau().demarrerPartie();
		}
		catch(HearthstoneException e) {
			
			e.printStackTrace();
		}
		
		Object obj;
		obj=Plateau.instancePlateau();

		try {
			joueur1.prendreTour();
		}
		catch(HearthstoneException e ) {
			
			es.println(e.getMessage());
		}

		while(((IPlateau)obj).estDemarree()) {
			
			es.println(Plateau.instancePlateau());
			String choix =menu();
			try {
				
				ihm.interagir(choix,obj);
			}
			catch(Exception e) {
				
				System.err.println(e.getMessage());
			}
		}
	}

public static String menu(){
		
		ArrayList<String> menu=new ArrayList<String>();
		Interface i=ihm;
		
		es.println("\n Que veux tu faire ?");
		while (i != null) {
			menu.add(i.getDescription());
			i = i.getSuivant();
		}
		
		int n = 0;
		String s;
		while(n<4) {
				s=menu.get(n);
				int nb=n+1;
				es.println(""+nb+". "+s);
				n++;
			
		}
		
		es.println("");
		es.println("Votre choix : ");
		int choix = es.readInt();
		
		return menu.get(choix-1);
		
	}
	
	public static Interface initialiserInterface() {
		
		Interface monInterface=null;
		monInterface=new InterfaceJouerSort(monInterface);
		monInterface=new InterfaceCharge(monInterface);
		monInterface=new InterfaceExecuterAction(monInterface);
		monInterface=new InterfaceFinirTour(monInterface);
		monInterface=new InterfaceJouerCarteMain(monInterface);
		monInterface=new InterfaceJouerCarteJeu(monInterface);
		monInterface=new InterfaceUtiliserPouvoir(monInterface);
		
		
		return monInterface;
	}

}

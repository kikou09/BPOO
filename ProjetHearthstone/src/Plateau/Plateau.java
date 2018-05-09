package Plateau;

import java.util.ArrayList;
import Plateau.IPlateau;
import application.HearthstoneException;
import joueur.IJoueur;
import joueur.Joueur;
import carte.ICarte;

public final class Plateau implements IPlateau {
	
	private static Plateau plateau=null;
	private IJoueur adversaire ;
	private IJoueur joueurCourant;
	private boolean demarree;
	private ArrayList<IJoueur> joueurPresents;   //JoueursPresents dans le jeu 
	
	
	public static Plateau instancePlateau() {
		if(plateau==null)
			plateau=new Plateau();
		return plateau;
		
	}
	
	private Plateau()   //Constructeur
	{
		this.adversaire=null;
		this.joueurCourant=null;
		this.demarree=false;
		this.joueurPresents=new ArrayList<IJoueur>();
	}
	
	public final IJoueur getJoueurCourant(){
		if(!demarree)
			return null;

		return this.joueurCourant;
	}
	
	public final void setJoueurCourant(IJoueur joueur) throws HearthstoneException
	{
		if(!this.joueurPresents.contains(joueur))
			throw new IllegalArgumentException("Ce joueur n'est pas dans le jeu");
		if (joueur == null)
			throw new IllegalArgumentException("Le joueur ne doit pas être null");
		if(this.joueurCourant==null || !(joueurCourant.equals(joueur)))
		{
			this.joueurCourant=joueur;
		}
	}
	
	public final IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
	
		if(! demarree)
			throw new HearthstoneException("La partie n'a pas encore commence");
		if(joueur==null)
			throw new IllegalArgumentException("On ne peut pas recuperer l'adversaire d'un joueur null ");
		if(!(joueurPresents.contains(joueur)))
			throw new HearthstoneException("Ce joueur n'est même pas dans la partie");
		if(this.joueurPresents.get(0) != joueur)
			return this.joueurPresents.get(0);
		else 
			return this.joueurPresents.get(1);
		
	}
	
	private String dessinerCartesPoses(IJoueur joueur) {
		
		String chaine ="\n\n\t\t Cartes posées sur le plateau : \n\n";
		
		if(joueur.getCartes_Poses().size()!=0) {
			for(ICarte c: joueur.getCartes_Poses()) {
			
			chaine= chaine + "\t" + c + "\n";
			
			}
		}
		
		return chaine;
	}
	
	private String dessinerMain() {
		
		
		String chaine = "\n			 Ta main			\n";
   
		if (this.joueurCourant.getMain().size() == 0)
		{
			chaine+= "\tBen, ta main est vide....\n";
		}
		else
		{
			IJoueur joueur_courant=this.joueurCourant;
			for(ICarte c : joueur_courant.getMain())
			{
    	
				chaine+=  "\n\t\t" + c + "\n";
			}
		}
    return chaine ;
}
	
	public String toString() {
		
		String ch="";
		
		ch+="\t\t\t\t\t AU TOUR DE " + this.joueurCourant.getPseudo() +"\n\n\n" ;
		ch+=this.joueurPresents.get(0);
		
		if(this.joueurCourant.equals(this.joueurPresents.get(0)))
			ch+=dessinerMain();
		
		ch+=dessinerCartesPoses(this.joueurPresents.get(0));
		
		ch+=("\t\t __________________________________________\n");
		for(int i=0;i<4;i++) 										
			ch+=("\t\t|                                          |\n");
		
		ch+=("\t\t|__________________________________________|\n\n");
		
		ch+=this.joueurPresents.get(1);
		
		if(this.joueurCourant.equals(this.joueurPresents.get(1)))
			ch+=dessinerMain();
		ch+=dessinerCartesPoses(this.joueurPresents.get(1));
		return ch;
	}
	
	
	public boolean estDemarree() {
		return this.demarree;
	}

	public final void ajouterJoueur(IJoueur joueur) throws HearthstoneException{
		if (this.demarree)
			throw new HearthstoneException("La partie a deja commence");
		if(this.joueurPresents.contains(joueur))
			throw new HearthstoneException("Ce joueur est deja present dans la partie");
		if(this.joueurPresents.size()==2)
			throw new HearthstoneException("Vous ne pouvez plus ajouter de joueur dans la partie");
		else
			this.joueurPresents.add(joueur);
	}
	
	public final void demarrerPartie() throws HearthstoneException{
		if (this.demarree)
			throw new HearthstoneException("La partie a deja commence");
		if(this.joueurPresents.size() !=2)
			throw new HearthstoneException("Il faut 2 joueurs pour pouvoir jouer");
		
		this.demarree=true;
		
	}

	
	public final void finTour(IJoueur Joueur) throws HearthstoneException{
		if(!this.demarree)
			throw new HearthstoneException("La partie n'a pas encore commence");
		else if (!(this.joueurCourant.equals(Joueur)))
			throw new HearthstoneException("Ce n'est pas ton tour");
		this.getAdversaire(Joueur).prendreTour();
	
	}
	
	
	public final void gagnePartie (IJoueur joueur) throws HearthstoneException {
		this.demarree=false;
		String msg=this.instancePlateau().getAdversaire(joueur).getPseudo() + "Pour arrêter de perdre il faut arrêter de jouer ! ";
		msg+="**** "+ joueur.getPseudo() + " a gagne ! ****";
		
		
		System.out.println(msg);
	
	}
	
}
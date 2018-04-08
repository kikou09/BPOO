package Plateau;

import java.util.ArrayList;
import Plateau.IPlateau;
import joueur.Joueur;

public final class Plateau implements IPlateau {

	//private Joueur adversaire ;
	private Joueur joueurCourant;
	private boolean demarree;
	private ArrayList<Joueur> joueurPresents;   //JoueursPresents dans le jeu 
	
	public Plateau()   //Constructeur
	{
		//this.adversaire=null;
		this.joueurCourant=null;
		this.demarree=false;
		this.joueurPresents=new ArrayList<Joueur>();
	}
	
	public final Joueur getJoueurCourant(){
		if(!demarree)
			return null;

		return this.joueurCourant;
	}
	
	public final void setJoueurCourant(Joueur joueur) //throws jeu.ExceptionHearthstone
	{
		if (joueur == null)
		{
			System.out.println("erreur joueur courant null");
		}
			//throw new ExceptionHearthsone("Le joueur ne doit pas être null");
		if(this.joueurCourant==null || !(joueurCourant.equals(joueur)))
		{
			this.joueurCourant=joueur;
		}
	}
	
	public final Joueur getAdversaire(Joueur joueur) //throws jeu.ExceptionHearthstone
	{
		if(! demarree)
			System.out.println("erreur partie pas demarrer");	
			//throw new ExceptionHearthsone("La partie n'a pas encore commencé");
		if(joueur==null)
			System.out.println("erreur joueur null ");
			//throw new ExceptionHearthsone("On ne peut pas recuperer l'adversaire d'un joueur null ");
		if(!(joueurPresents.contains(joueur)))
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Ce joueur n'est même pas dans la partie");
		if(this.joueurPresents.get(0) != joueur)
			return this.joueurPresents.get(0);
		else	
			return this.joueurPresents.get(1);
	}
	
	public String toString() {		
		return "Plateau [ demarree = " + this.demarree +  "]";
	}
	
	
	public boolean estDemarree() {
		return this.demarree;
	}

	public final void ajouterJoueur(Joueur joueur) { //throws jeu.ExceptionHearthstone{
		if (this.demarree)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("La partie a deja commencé");
		if(this.joueurPresents.contains(joueur))
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Ce joueur est deja présent dans la partie");
		if(this.joueurPresents.size()==2)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Vous ne pouvez plus ajouter de joueur dans la partie");
		else
			this.joueurPresents.add(joueur);
	}
	
	public final void demarrerPartie() /*throws jeu.ExceptionHearthstone*/{
		if (this.demarree)
			System.out.println("Erreur");
			//throw new ExceptionHearthsone("La partie a deja commence");
		if(this.joueurPresents.size() !=2)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Il faut 2 joueurs pour pouvoir jouer");
		
		this.demarree=true;
		
	}

	
	public final void finTour(Joueur Joueur) { //throws jeu.ExceptionHearthstone{
		if(!this.demarree)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("La partie n'a pas encore commencé");
		else if (this.joueurCourant!=Joueur)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("C'est n'est pas ton tour");
		this.getAdversaire(Joueur).prendreTour();
	
	}
	
	
	public final void gagnePartie (Joueur joueur) { //throws jeu.ExceptionHearthstone{
		this.demarree=false;
		String msg="**** "+ joueur.getPseudo() + " a gagne ! ****";
		
		System.out.println(msg);
	
	}
	
}
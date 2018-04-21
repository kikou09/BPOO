package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.Serviteur;
import heros.Heros;
import joueur.IJoueur;
import joueur.Joueur;
public class AttaqueDuHeros extends Capacite {
	
	public AttaqueDuHeros(String n , String des , int d) {
	
		super(n,des,d);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		
		if(cible==null) {
			System.out.println("erreur");
			throw new IllegalArgumentException("Il faut une cible ");
		}	
		if(this.utilise) {
			System.out.println("erreur");
			throw new HearthstoneException ("Capacite deja utilise ");
		}
		
		if(!(cible instanceof Joueur)) {
			throw new IllegalArgumentException(" Vous devez attaquer le joueur adverse ");
		}
		
		IJoueur j_courant= Plateau.instancePlateau().getJoueurCourant();
		IJoueur adverse=Plateau.instancePlateau().getAdversaire(j_courant);
		adverse.getHeros().perteVie(this.degats);
		if(adverse.getHeros().estMort())
			Plateau.instancePlateau().gagnePartie(j_courant);
		/* ou  
		cible=((Joueur)cible);
		((Joueur)cible).getHeros().perteVie(this.degats);
		
		if(((Joueur)cible).getHeros().estMort()) {
			//Plateau.gagnePartie(Plateau.getJoueurCourant());
		}*/
		
	}

}

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
			throw new IllegalArgumentException("Il faut une cible ");
		}	
		if(this.utilise) {
			throw new HearthstoneException ("Capacite deja utilise ");
		}
		
		if(!(cible instanceof IJoueur)) {
			throw new IllegalArgumentException(" Vous devez attaquer le joueur adverse ");
		}
		 
		cible=((IJoueur)cible);
		((Joueur)cible).getHeros().perteVie(this.degats);
		
		if(((Joueur)cible).getHeros().estMort()) {
			Plateau.instancePlateau().gagnePartie(Plateau.instancePlateau().getJoueurCourant());
		}
		this.utilise=true;
		
	}

}

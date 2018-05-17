package capacite;

import Plateau.IPlateau;
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
	
	public void executerEffetMiseEnJeu(Object o) throws HearthstoneException {
			
		if(this.utilise) {
			throw new HearthstoneException ("Capacite deja utilise ");
		}
		
		o=Plateau.instancePlateau();
		IJoueur joueur_courant=((IPlateau)o).getJoueurCourant();
		IJoueur adversaire=((IPlateau)o).getAdversaire(joueur_courant);
		adversaire.getHeros().perteVie(this.degats);
		
		if(adversaire.getHeros().estMort()) {
			((IPlateau)o).gagnePartie(joueur_courant);
		}
		this.utilise=true;
		
	}

}

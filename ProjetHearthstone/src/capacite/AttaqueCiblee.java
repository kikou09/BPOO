package capacite;

import joueur.Joueur;
import Plateau.Plateau;
import application.HearthstoneException;
import carte.Carte;
import carte.Serviteur;

public class AttaqueCiblee extends Capacite {
	
	public AttaqueCiblee(String n , String des , int d) {
		
		super(n,des,d);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		
		if(cible==null) {
			System.out.println("erreur");
			throw new IllegalArgumentException("Il faut une cible ");
		}	
		if(this.utilise) {
			System.out.println("erreur");
			throw new HearthstoneException("Capacite deja utilise ");
		}
		
		if(!(cible instanceof Joueur) || !(cible instanceof Serviteur)) {
			throw new IllegalArgumentException(" Vous devez attaquer le joueur ou un serviteur ");
		}
		
		if(cible instanceof Joueur) {
		
			cible=((Joueur)cible);
			((Joueur)cible).getHeros().perteVie(this.degats);
		
			if(((Joueur)cible).getHeros().estMort()) {
				Plateau.instancePlateau().gagnePartie(Plateau.instancePlateau().getJoueurCourant());
			}
		
			return;
		}
		
		if(cible instanceof Serviteur)
		{
			cible=((Serviteur)cible);
			((Serviteur)cible).subitAttaque(this.degats);
			if(((Serviteur)cible).disparait()){
				((Serviteur)cible).getProprietaire().perdreCarte(((Carte)cible));
			}
			return;
		}
		this.utilise=true;
	}

}

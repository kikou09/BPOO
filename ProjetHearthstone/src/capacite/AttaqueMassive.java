package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.ICarte;
import carte.Serviteur;
import joueur.IJoueur;

public class AttaqueMassive extends Capacite {

	public AttaqueMassive(String n, String d, int deg) {
		super(n, d, deg);
	}

	
	@Override
	public void executerAction(Object cible) throws HearthstoneException  {
		if(this.utilise) {
			throw new HearthstoneException ("Sort deja utilise ");
		}
		
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		cible=(IJoueur)cible;
		//cible=Plateau.instancePlateau().getAdversaire(joueur_courant);
		
		 for(ICarte c : ((IJoueur) cible).getCartes_Poses()){
		 
		  		if(c instanceof Serviteur){
		  			((Serviteur) c).subitAttaque(this.degats);
		  			if(((Serviteur)c).disparait())
		  				((IJoueur) cible).perdreCarte((Serviteur)c);
		  		}
		  }
		 
		this.utilise=true;
		
	}
}

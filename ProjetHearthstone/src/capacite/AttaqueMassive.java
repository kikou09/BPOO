package capacite;

import java.util.ArrayList;
import java.util.Iterator;

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
		IJoueur adversaire=Plateau.instancePlateau().getAdversaire(joueur_courant);
		ArrayList<ICarte> copie_cartes_poses=(ArrayList<ICarte>) adversaire.getCartes_Poses().clone();
		
		Iterator<ICarte> c=copie_cartes_poses.iterator();
		while(c.hasNext()){
			
				ICarte element=(ICarte) c.next();
		  		if(element instanceof Serviteur){
		  			((Serviteur) element).subitAttaque(this.degats);
		  			if(((Serviteur) element).disparait()) {
		  				((IJoueur) adversaire).perdreCarte((Serviteur)element);
		  			}
		  		}
		  }
		 
		this.utilise=true;
				
	}
}

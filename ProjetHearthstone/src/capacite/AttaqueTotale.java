package capacite;

import java.util.ArrayList;

import Plateau.Plateau;
import joueur.IJoueur;
import application.HearthstoneException;
import carte.ICarte;
import carte.Serviteur;

public class AttaqueTotale extends Capacite {
	
	public AttaqueTotale(String n , String des , int d) {
		
		super(n,des,d);
	}

	public void executerAction(Object cible) throws HearthstoneException {
		
		if(cible==null) {
			throw new HearthstoneException("Il faut une cible ");
		}	
		if(this.utilise) {
			throw new HearthstoneException ("Capacite deja utilise ");
		}
		
		cible=(IJoueur)cible;
		//cible=Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant());
		
		
		for(ICarte c :((IJoueur) cible).getCartes_Poses()){
		 	if(c instanceof Serviteur){
		 	
		 		Serviteur s=((Serviteur)c);
		 		s.subitAttaque(this.degats);
		 		if(s.disparait())
		 			((IJoueur)cible).perdreCarte(s);
		 		}
		 	}
		
		this.utilise=true;
	}
}

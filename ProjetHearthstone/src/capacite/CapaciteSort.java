package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import joueur.IJoueur;

public class CapaciteSort extends Capacite {

	public CapaciteSort(String n, String d, int deg) {
		super(n, d, deg);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		
		if(cible==null)
			throw new IllegalArgumentException("Il faut une cible ");
		if(this.utilise)
			throw new HearthstoneException ("Sort deja utilise");
		if(cible instanceof IJoueur)
		{
			((IJoueur) cible).getHeros().perteVie(this.degats);
			if(((IJoueur) cible).getHeros().estMort())
				Plateau.instancePlateau().gagnePartie(Plateau.instancePlateau().getJoueurCourant());
			 
			this.utilise=true;
		}
		else
			throw new HearthstoneException ("cible inconnue");
		
	

	}
}

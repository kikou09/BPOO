package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import joueur.IJoueur;

public class CapaciteDegats extends Capacite {
	
	public CapaciteDegats(String n , String d , int degats) {
		
		super(n,d,degats);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		
		if(cible==null)
			throw new IllegalArgumentException("Il faut une cible ");
		if(this.utilise)
			throw new HearthstoneException ("Capacite deja utilise");
		if(!(cible instanceof IJoueur))
			throw new HearthstoneException ("Il vaut viser le joueur");
		
		IJoueur adversaire=(IJoueur)cible;
		adversaire.getHeros().perteVie(this.degats);
		if(adversaire.getHeros().estMort())
			Plateau.instancePlateau().gagnePartie(Plateau.instancePlateau().getJoueurCourant());
		this.utilise=true;
	}


}

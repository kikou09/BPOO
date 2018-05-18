package capacite;

import application.HearthstoneException;
import carte.Serviteur;

/**
 * Capacite qui reduit le nombre de points de vie d'un serviteur
 */
public class Chasseur extends Capacite {
	
	public Chasseur() {
		
		
		super("Marque du chasseur", "Reduit à 1 le nombre de points de vie d'un serviteur",0);
	}
	
	
public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		
		if (cible==null) {
			throw new HearthstoneException("Marque du chasseur necessite une cible");
		}
		
		if (this.utilise) {
			throw new HearthstoneException ("Capacite deja utilise");
		}
				
		if(!(cible instanceof Serviteur))
		{
			throw new HearthstoneException("Cible doit être un serviteur");
		}
		
		((Serviteur) cible).subitAttaque(((Serviteur) cible).getVie() - 1);
		this.utilise=true;
		
	
	}

}

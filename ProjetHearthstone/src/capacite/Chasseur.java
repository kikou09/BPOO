package capacite;

import application.HearthstoneException;
import carte.Serviteur;

public class Chasseur extends Capacite {
	
	public Chasseur() {
		
		
		super("Marque du chasseur", "Reduit à 1 le nombre de points de vie d'un serviteur",0);
	}
	
	
public void executerAction(Object cible) throws HearthstoneException {
		
		if (cible==null) {
			throw new IllegalArgumentException("Marque du chasseur necessite une cible");
		}
		
		if (this.utilise) {
			throw new HearthstoneException ("Capacite deja utilise");
		}
				
		if(!(cible instanceof Serviteur))
		{
			throw new IllegalArgumentException("Cible doit être un serviteur");
		}
		
		((Serviteur) cible).subitAttaque(((Serviteur) cible).getVie() - 1);
		this.utilise=true;
		
	
	}

}

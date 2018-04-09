package capacite;

import carte.Serviteur;

public class Chasseur extends Capacite {
	
	public Chasseur() {
		
		
		super("Marque du chasseur", "Reduit à 1 le nombre de points de vie d'un serviteur",0);
	}
	
	
public void executerAction(Object cible) {
		
		if (cible==null) {
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Marque du chasseur necessite une cible");
		}
		
		if (this.utilise==1) {
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Deja utilise");
		}
				
		if(!(cible instanceof Serviteur))
		{
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Cible doit être un serviteur");
		}
		
		((Serviteur) cible).subitAttaque(((Serviteur) cible).getVie() - 1);
		this.utilise=1;
		
	
	}

}

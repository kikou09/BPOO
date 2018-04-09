package capacite;

import carte.Serviteur;
public final class Charge extends ACapacite{
	
	public Charge() {
		
		super("Charge", " Permet � un serviteur de ne pas attendre avant d'attaquer");
	}

	@Override
	public void executerAction(Object cible) {
		
		if(cible==null)
			//erreur necessite cible
			//throw new ExceptionHearthsone("Charge necessite une cible");
			
		if(!(cible instanceof Serviteur))
			//throw new ExceptionHearthsone("La cible doit �tre un serviteur);
			
		cible=((Serviteur)cible);
		((Serviteur)cible).setAttente(0);
		
	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}

}

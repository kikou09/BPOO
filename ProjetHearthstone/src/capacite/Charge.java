package capacite;

import application.HearthstoneException;
import carte.Serviteur;
public final class Charge extends ACapacite{
	
	public Charge() {
		
		super("Charge", " Permet à un serviteur de ne pas attendre avant d'attaquer");
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException  {
		
		if(cible==null)
			throw new HearthstoneException("Charge necessite une cible");
			
		if(!(cible instanceof Serviteur))
			throw new HearthstoneException("La cible doit être un serviteur");
			
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
	
	/**
	 * Met l'attente du serviteur cible du joueur courant à 0 (il n'a pas besoin d'attendre avant d'attaquer)
	 * @param cible 
	 * @throws HearthstoneException :
	 * 						si la cible est null
	 * 						si la cible n'est pas un serviteur
	 * @see setAttente dans la classe Serviteur
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		
		if(cible==null)
			throw new HearthstoneException("Charge necessite une cible");
			
		if(!(cible instanceof Serviteur))
			throw new HearthstoneException("La cible doit être un serviteur");
			
		cible=((Serviteur)cible);
		((Serviteur)cible).setAttente(0);
		
	}

}

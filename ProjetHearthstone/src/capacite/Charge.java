package capacite;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import carte.Serviteur;

/**
 * Capacite qui permet a un serviteur de ne pas attendre avant d'attaquer
 */
public final class Charge extends ACapacite{
	
	public Charge() {
		
		super("Charge", " Permet à un serviteur de ne pas attendre avant d'attaquer");
	}

/*	public void executerAction(Object cible) throws HearthstoneException  {
		
		if(cible==null)
			throw new HearthstoneException("Charge necessite une cible");
			
		if(!(cible instanceof Serviteur))
			throw new HearthstoneException("La cible doit être un serviteur");
			
		((Serviteur)cible).setAttente(0);		
	}
*/
	
	public void executerEffetDebutTour() {}

	public void executerEffetDisparition(Object cible) {}

	public void executerEffetFinTour() {}
	
	/**
	 * Met l'attente du serviteur cible du joueur courant à 0 (il n'a pas besoin d'attendre avant d'attaquer)
	 * @param cible 
	 * @throws HearthstoneException :
	 * 						si la cible est null
	 * 						si la cible n'est pas un serviteur
	 * @see setAttente dans la classe Serviteur
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException , HearthstoneCapaciteException {
		
		if(cible==null)
			throw new HearthstoneCapaciteException("Charge necessite une cible");
			
		if(!(cible instanceof Serviteur))
			throw new HearthstoneException("La cible doit être un serviteur");
			
		cible=((Serviteur)cible);
		((Serviteur)cible).setAttente(0);
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}

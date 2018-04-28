package capacite ;

import application.HearthstoneException;

public abstract interface ICapacite{
	public abstract void executerAction(Object cible)  throws HearthstoneException ; 
	public abstract void executerEffetDebutTour() ; 
	public abstract void executerEffetDisparition(Object cible) ; 
	public abstract void executerEffetFinTour() ; 
	public abstract void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;
	public abstract String getDescription();
	public abstract String getNom();

}

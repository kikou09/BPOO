package capacite;

import application.HearthstoneException;

public abstract class Capacite extends ACapacite{
	
	int degats ;
	
	public Capacite(String n, String d, int deg ){
	
		super(n,d);
		this.degats=deg;		
	}

	public int getDegats() {
		return degats;
	}
	
	public void dejaUtilise() {
		this.utilise=true;
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {}

	@Override
	public void executerEffetDebutTour() {
		this.utilise=false;
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {}

	@Override
	public void executerEffetFinTour() {}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {}
	
	
	
	

}

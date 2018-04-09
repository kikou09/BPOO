package capacite;

public class Capacite extends ACapacite{
	
	int degats ;
	
	public Capacite(String n, String d, int deg ){
	
		super(n,d);
		this.degats=deg;		
	}

	public int getDegats() {
		return degats;
	}
	
	public void dejaUtilise() {
		this.utilise=1;
	}

	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
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

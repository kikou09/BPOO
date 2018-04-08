package carte;

import joueur.Joueur;

public final class Sort extends Carte {

	@Override
	public boolean disparait() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}
	
	//private Capacite capacite;
	
	public Sort ( String n , int cout , Joueur joueur /*,Capacite c*/ )
	{
		super(n,cout,joueur);
		//this.capacite=c;
	}
	
	/*
	public Capacite getCapacite(){
		return this.capacite;
	}*/
	
	public String toString(){
		return "Sort [ " + super.toString() /*+ " capacite = " + this.capacite + */ + "]" ;
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

}
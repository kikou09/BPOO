package carte;

import joueur.IJoueur;
import application.HearthstoneException;
import capacite.ICapacite;

public final class Sort extends Carte {
	
	private ICapacite capacite;
	
	public Sort ( String n , int cout , IJoueur joueur , ICapacite c )
	{
		super(n,cout,joueur);
		if(c==null)
			throw new IllegalArgumentException("la capacité ne doit pas être null");
		this.capacite=c;
	}

	@Override
	public boolean disparait() {
		return true;
	}

	@Override
	public void executerAction(Object cible) {	
	}

	
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
		
			this.capacite.executerEffetMiseEnJeu(cible);
			super.getProprietaire().perdreCarte(this);	
	}

	
	public void executerEffetDisparition(Object cible) {}	
		
	
	public ICapacite getCapacite(){
		return this.capacite;
	}
	
	public String toString(){
		return "Sort [ " + super.toString() + this.capacite +  "]" ;
	}

	public void executerEffetFinTour() {}

	public void executerEffetDebutTour() {}

}
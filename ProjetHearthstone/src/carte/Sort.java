package carte;

import joueur.IJoueur;
import joueur.Joueur;
import heros.Heros;
import application.HearthstoneException;
import capacite.ACapacite;
import capacite.ICapacite;

public final class Sort extends Carte {
	
	private ICapacite capacite;


	@Override
	public boolean disparait() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void executerAction(Object cible) {
		try {
			this.capacite.executerAction(cible);
			super.getProprietaire().perdreCarte(this);
		}
		catch(HearthstoneException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {}

	@Override
	public void executerEffetDisparition(Object cible) {}	
	
	public Sort ( String n , int cout , IJoueur joueur , ICapacite c )
	{
		super(n,cout,joueur);
		if(c==null)
			throw new IllegalArgumentException("la capacité ne doit pas être null");
		this.capacite=c;
	}
	
	
	public ICapacite getCapacite(){
		return this.capacite;
	}
	
	public String toString(){
		return "Sort [ " + super.toString() + this.capacite +  "]" ;
	}

	@Override
	public void executerEffetFinTour() {}

	@Override
	public void executerEffetDebutTour() {}

}
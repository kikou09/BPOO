package carte;

import joueur.IJoueur;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import capacite.ICapacite;

/**
 * Un sort est une Carte qui qui disparait dès la mise en jeu
 * @author Jorane SCHUSTER , Claire MICHALON
 */
public final class Sort extends Carte {
	
	private ICapacite capacite;
	
	public Sort ( String n , int cout , IJoueur joueur , ICapacite c )
	{
		super(n,cout,joueur);
		if(c==null)
			throw new IllegalArgumentException("la capacité ne doit pas être null");
		this.capacite=c;
	}

	public boolean disparait() {
		return true;
	}

	public void executerAction(Object cible) throws HearthstoneException {}

	
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException {
		
		
			this.capacite.executerEffetMiseEnJeu(cible);
			super.getProprietaire().perdreCarte(this);	
	}

	
	public void executerEffetDisparition(Object cible) throws HearthstoneException {}	
		
	
	public ICapacite getCapacite(){
		return this.capacite;
	}
	
	public String toString(){
		return "Sort [ " + super.toString() + this.capacite +  "]" ;
	}

	public void executerEffetFinTour() throws HearthstoneException {}

	public void executerEffetDebutTour() throws HearthstoneException {}

}
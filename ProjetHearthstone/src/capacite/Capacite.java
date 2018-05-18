package capacite;

import application.HearthstoneException;

/**
 * Classe abstraite qui etend ACapacite 
 * Certaines capacités infligent des degats 
 *
 */
public abstract class Capacite extends ACapacite{
	
	int degats ;
	
	public Capacite(String n, String d, int deg ){
	
		super(n,d);
		this.degats=deg;		
	}

	public int getDegats() {
		return degats;
	}
	
	/**
	 * Certaines capacité agissent quand on le demande, et éventuellement sur une cible...
	 */
	public void executerAction(Object cible) throws HearthstoneException {}

	/**
	 * Certaines capacité agissent en début de tour 
	 */
	public void executerEffetDebutTour() throws HearthstoneException {}

	/**
	 * Certaines capacité agissent lorsque la carte disparaît du jeu
	 */
	public void executerEffetDisparition(Object cible) throws HearthstoneException {}

	/**
	 * Certaines capacité agissent en fin de tour
	 */
	public void executerEffetFinTour() throws HearthstoneException {}

	/**
	 * Certaines capacité agissent en début de mise en jeu
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {}
	
	
	
	

}

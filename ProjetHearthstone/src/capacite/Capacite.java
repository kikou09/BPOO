package capacite;

import application.HearthstoneException;

/**
 * Classe abstraite qui etend ACapacite 
 * Certaines capacit�s infligent des degats 
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
	 * Certaines capacit� agissent quand on le demande, et �ventuellement sur une cible...
	 */
	public void executerAction(Object cible) throws HearthstoneException {}

	/**
	 * Certaines capacit� agissent en d�but de tour 
	 */
	public void executerEffetDebutTour() throws HearthstoneException {}

	/**
	 * Certaines capacit� agissent lorsque la carte dispara�t du jeu
	 */
	public void executerEffetDisparition(Object cible) throws HearthstoneException {}

	/**
	 * Certaines capacit� agissent en fin de tour
	 */
	public void executerEffetFinTour() throws HearthstoneException {}

	/**
	 * Certaines capacit� agissent en d�but de mise en jeu
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {}
	
	
	
	

}

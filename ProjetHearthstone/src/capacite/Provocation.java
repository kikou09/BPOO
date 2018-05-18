package capacite;

/**
 * Oblige l'adversaire à viser ce serviteur
 */
public class Provocation extends ACapacite {
	
	public Provocation(){
	
		super("Provocation", "Oblige l'adversaire à viser le serviteur qui detient cette capacite");
	}

	
	public void executerAction(Object cible) {}

	public void executerEffetDebutTour() {}

	public void executerEffetDisparition(Object cible) {}

	public void executerEffetFinTour() {}

	public void executerEffetMiseEnJeu(Object cible) {}

}

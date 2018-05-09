package cor;


public class InterfaceQuitter extends Interface {

	public InterfaceQuitter(Interface suivant) {
		
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		
		return getDescription().equals(choix);
		
	}

	@Override
	public void executerInteraction(Object o) {
		System.out.println("Jouer pour jouer n'est pas longtemps intéressant. \nTandis que "
				+ "jouer au travail , jouer à faire semblant de ne pas avoir le temps de jouer,\n"
				+ "voila le beau jeu quand on a hâte d'etre grand. G. Vigneault");
		System.exit(0);
	}

	@Override
	public String getDescription() {
		return "Quitter";
	}
	
	

}

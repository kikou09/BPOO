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
		System.out.println("Au revoir");
		System.exit(0);
	}

	@Override
	public String getDescription() {
		return "Quitter";
	}
	
	

}

package cor;

import dessin.Dessin;

public class InterfaceQuitter extends Interface {

	public InterfaceQuitter(Interface suivant) {
		
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		
		return getDescription().equals(choix);
		
	}

	@Override
	public void executerInteraction(Dessin d) {
		System.out.println("Au revoir");
		System.exit(0);
	}

	@Override
	public String getDescription() {
		return "Quitter";
	}
	
	

}

package cor;

import Plateau.Plateau;
import application.HearthstoneException;

public class InterfaceFinirTour extends Interface {

	public InterfaceFinirTour(Interface suivant) {
		super(suivant);
	}

	
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof String))
			return false;
		return getDescription().equals(choix);
	}

	
	public void executerInteraction(Object o) {
		
		Console es=application.Hearthstone.es;
		
		try {
				Plateau.instancePlateau().getJoueurCourant().finirTour();
		}
		catch(HearthstoneException e){
			
			es.println(e.getMessage());
		}
	}

	
	public String getDescription() {
		return "Finir le tour ";
	}

}

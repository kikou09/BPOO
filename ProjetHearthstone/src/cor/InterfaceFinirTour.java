package cor;

import Plateau.Plateau;
import application.HearthstoneException;

public class InterfaceFinirTour extends Interface {

	public InterfaceFinirTour(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof String))
			return false;
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Object o) {
		
		Console es=new Console();
		try {
				Plateau.instancePlateau().getJoueurCourant().finirTour();
		}
		catch(HearthstoneException e){
			
			es.println(e.getMessage());
		}
	}

	@Override
	public String getDescription() {
		return "Finir le tour ";
	}

}

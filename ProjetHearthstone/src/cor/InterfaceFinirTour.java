package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import forme.Cercle;

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
			
			e.printStackTrace();
		}
	}

	@Override
	public String getDescription() {
		return "Finir le tour ";
	}

}

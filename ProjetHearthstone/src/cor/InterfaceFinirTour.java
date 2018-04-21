package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import dessin.Dessin;
import forme.Cercle;

public class InterfaceFinirTour extends Interface {

	public InterfaceFinirTour(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Dessin d) {
		
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

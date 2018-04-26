package cor;

import Plateau.Plateau;
import application.Hearthstone;
import application.HearthstoneException;
import carte.ICarte;

public class InterfaceJouerCarteJeu extends Interface {

	public InterfaceJouerCarteJeu(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof String))
			return false;
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException{
		
		Console es=new Console();
		String chaine="Quelle carte veut tu jouer ?";
		es.println(chaine);
		
		String choix_carte=es.readLine();
		
		try {
			Object carte=Plateau.instancePlateau().getJoueurCourant().getCarteEnJeu(choix_carte);
			o=carte;
			if(carte==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
			try {
				Hearthstone.ihm.interagir(carte, o);
			}
			catch(Exception e) {
				es.println(e.getMessage());
			}

		}
		catch(HearthstoneException e1) {
			
			es.println(e1.getMessage());
		}
	}

	@Override
	public String getDescription() {
		return "Jouer une carte posée sur le plateau " ;
	}

}

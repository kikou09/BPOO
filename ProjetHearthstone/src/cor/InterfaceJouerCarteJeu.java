package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.ICarte;

public class InterfaceJouerCarteJeu extends Interface {

	public InterfaceJouerCarteJeu(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException{
		
		Console es=new Console();
		String chaine="Quelle carte veut tu jouer ?";
		es.println(chaine);
		
		String choix_carte=es.readLine();
		
		try {
			ICarte carte=Plateau.instancePlateau().getJoueurCourant().getCarteEnJeu(choix_carte);
			if(carte==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
		}
		catch(HearthstoneException e) {
			
			es.println(e.getMessage());
		}
	}

	@Override
	public String getDescription() {
		return "Jouer une carte posée sur le plateau " ;
	}

}

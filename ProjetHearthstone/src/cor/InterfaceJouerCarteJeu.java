package cor;

import dessin.Dessin;

public class InterfaceJouerCarteJeu extends Interface {

	public InterfaceJouerCarteJeu(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Dessin d) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		return "Jouer une carte posée sur le plateau " ;
	}

}

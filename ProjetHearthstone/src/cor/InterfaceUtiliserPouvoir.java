package cor;

import dessin.Dessin;

public class InterfaceUtiliserPouvoir extends Interface {

	public InterfaceUtiliserPouvoir(Interface suivant) {
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
		return "Utiliser le pouvoir du héros ";
	}

}

package cor;

import dessin.Dessin;

public class InterfaceJouerCarteMain extends Interface {

	public InterfaceJouerCarteMain(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Dessin d) {
		System.out.println(d.toXml());

	}

	@Override
	public String getDescription() {
		return "Jouer une carte de ta main ";
	}

}

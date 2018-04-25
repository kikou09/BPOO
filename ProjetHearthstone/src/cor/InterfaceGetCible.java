package cor;

import application.HearthstoneException;

public class InterfaceGetCible extends Interface {

	public InterfaceGetCible(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}

package cor;

import application.HearthstoneException;

public class InterfaceExecuterAction extends Interface {

	public InterfaceExecuterAction(Interface suivant) {
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

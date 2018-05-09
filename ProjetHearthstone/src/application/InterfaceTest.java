package application;

import cor.Interface;

public class InterfaceTest extends Interface {

	public InterfaceTest(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}

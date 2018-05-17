package cor;
import capacite.Capacite;
import capacite.Pioche;
import Plateau.Plateau;
import application.HearthstoneException;

public class InterfaceTest extends Interface {

	public InterfaceTest(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		
		for(int i=0;i<15;i++) {
			Plateau.instancePlateau().getJoueurCourant().piocher();
		}
		
		Plateau.instancePlateau().getJoueurCourant().setMana(20);

	}

	@Override
	public String getDescription() {
		return "Crash Test";
	}

}

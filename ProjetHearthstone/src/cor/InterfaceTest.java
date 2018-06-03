package cor;
import Plateau.Plateau;
import application.HearthstoneException;


/**
 * Interface pour test pour avoir toutes les cartes dans la main et un mana de 20
*/
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
		
		for(int i=0;i<14;i++) {
			Plateau.instancePlateau().getJoueurCourant().piocher();
		}
		
		Plateau.instancePlateau().getJoueurCourant().setMana(20);

	}

	@Override
	public String getDescription() {
		return "Crash Test (Pioche toutes les cartes et met 20 point de mana)";
	}

}

package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import capacite.Charge;
import carte.Sort;

public class InterfaceCharge extends Interface {

	public InterfaceCharge(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof Sort))
			return false;
		if(!(((Sort)choix).getCapacite() instanceof Charge))
			return false;
		return true;
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {

		Console es=new Console();
		String chaine="Sur quel serviteur de ton jeu ?";
		es.println(chaine);
		
		String carte=es.readLine();
		try {
			if(Plateau.instancePlateau().getJoueurCourant().getCarteEnJeu(carte)==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
	
		}
		catch(HearthstoneException e) {
			es.println(e.getMessage());
		}
	}

	@Override
	public String getDescription() {
		return "Sort charge";
	}

}

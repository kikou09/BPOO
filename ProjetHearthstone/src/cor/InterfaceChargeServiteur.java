package cor;

import Plateau.Plateau;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import capacite.Charge;
import carte.ICarte;
import carte.Serviteur;

/**
 * Interface pour utiliser la capacité Charge d'un serviteur ( sur lui même )
 */
public class InterfaceChargeServiteur extends Interface {

	public InterfaceChargeServiteur(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof Serviteur))
			return false;
		if((((Serviteur)choix).getCapacite() instanceof Charge)) {
				if(!(((Serviteur)choix).getCapacite().getUtilise()))
			return true;
		}
		return false;

	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException, HearthstoneCapaciteException {
		
		Plateau.instancePlateau().getJoueurCourant().jouerCarte((ICarte)o, (ICarte)o);


	}
	@Override
	public String getDescription() {
		return null;
	}

}

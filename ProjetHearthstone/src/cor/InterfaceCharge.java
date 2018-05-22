package cor;

import Plateau.Plateau;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import capacite.Charge;
import carte.ICarte;
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
	public void executerInteraction(Object o) throws HearthstoneException, HearthstoneCapaciteException {

		Console es=application.Hearthstone.es;
		if(Plateau.instancePlateau().getJoueurCourant().getCartes_Poses().size()==0)
			throw new HearthstoneException("Vous n'avez aucune carte en jeu");
		
		String chaine="Sur quel serviteur de ton jeu ?";
		es.println(chaine);
		
		String choix_carte=es.readLine();
		ICarte carte=Plateau.instancePlateau().getJoueurCourant().getCarteEnJeu(choix_carte);
		try {
			if(carte==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
	
		}
		catch(HearthstoneException e) {
			es.println(e.getMessage());
		}
		
		Plateau.instancePlateau().getJoueurCourant().jouerCarte(((ICarte)o), carte);
	}

	@Override
	public String getDescription() {
		return "Sort charge";
	}

}

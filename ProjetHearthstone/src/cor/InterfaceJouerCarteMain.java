package cor;

import Plateau.Plateau;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import carte.ICarte;


/**
 * Interface pour jouer une carte en main
*/
public class InterfaceJouerCarteMain extends Interface {

	public InterfaceJouerCarteMain(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException, HearthstoneCapaciteException {
		Console es=application.Hearthstone.es;
		
		String chaine="Quelle carte veut tu jouer ?";
		es.println(chaine);
		
		String choix_carte=es.readLine();
		
		ICarte carte=Plateau.instancePlateau().getJoueurCourant().getCarteEnMain(choix_carte);
		if(carte==null)
			
			throw new HearthstoneException("Cette carte n'est pas dans ta main");
			
			//Essaie sans cible
		try{
				
				Plateau.instancePlateau().getJoueurCourant().jouerCarte(carte);
		}
			
		catch(HearthstoneException e1) {
			
			es.println("\n");
			System.err.println(e1.getMessage());
		}
		//Capacite qui necessite une cible		
		catch(HearthstoneCapaciteException e1) {
			
			es.println(e1.getMessage());
			
			try {
				application.Hearthstone.ihm.interagir(carte, carte);
			}
			catch(Exception e2) {
				
				es.println("\n");
				System.err.println(e2.getMessage());
			}
		}
			
		
	}

	@Override
	public String getDescription() {
		return "Jouer une carte de ta main ";
	}

}

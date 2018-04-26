package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.ICarte;

public class InterfaceJouerCarteMain extends Interface {

	public InterfaceJouerCarteMain(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerInteraction(Object o) {
		Console es=new Console();
		String chaine="Quelle carte veut tu jouer ?";
		es.println(chaine);
		
		String choix_carte=es.readLine();
		
		try {
			ICarte carte=Plateau.instancePlateau().getJoueurCourant().getCarteEnMain(choix_carte);
			if(carte==null)
				throw new HearthstoneException("Cette carte n'est pas dans ta main");
			
			//Essaie sans cible
			try{
				
				Plateau.instancePlateau().getJoueurCourant().jouerCarte(carte);
			}
			
			//Capacite qui necessite une cible
			catch(HearthstoneException e) {
				
				es.println("Erreur besoin d'une cible");
				//Object cible = application.Hearthstone.ihm.interagir(choix, carte);
			}
		}
		catch(HearthstoneException e) {
			
			es.println(e.getMessage());
		}

	}

	@Override
	public String getDescription() {
		return "Jouer une carte de ta main ";
	}

}

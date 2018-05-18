package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.ICarte;
import carte.Serviteur;
import carte.Sort;

public class InterfaceJouerSort extends Interface {

	public InterfaceJouerSort(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof Sort) && !(choix instanceof Serviteur))
			return false;
		return true;
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		
		Console es=application.Hearthstone.es;
		
		String chaine="Que vises tu ?\n ";
		chaine+="1.Le héros\n";
		chaine+="2.Une autre carte";
		es.println(chaine);
		
		int choix=es.readInt();
		if(choix==1) {
			
			Plateau.instancePlateau().getJoueurCourant().jouerCarte(((ICarte)o)
					,Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()));
		}
		else {
			
			String chaine2="Quelle carte vises tu ?";
			es.println(chaine2);
			String choix_carte=es.readLine();
			Object cible=(Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()).getCarteEnJeu(choix_carte));
			if(cible==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
			Plateau.instancePlateau().getJoueurCourant().jouerCarte((ICarte)o, cible);
		}

	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}

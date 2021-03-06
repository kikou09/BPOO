package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.ICarte;
import carte.Serviteur;

/**
 * Interface pour executer l'action d'un serviteur (attaque)
*/
public class InterfaceExecuterAction extends Interface {

	public InterfaceExecuterAction(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(choix instanceof Serviteur)
			if(((Serviteur)choix).getProprietaire().getCartes_Poses().contains(((Serviteur)choix))) {
				return true;
			}
		return false;
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		
		Console es=application.Hearthstone.es;
		
		String chaine="Que vises tu ?\n ";
		chaine+="1.Le h�ros\n";
		chaine+="2.Une autre carte";
		es.println(chaine);
		
		int choix=es.readInt();
		if(choix==1) {
			
			Plateau.instancePlateau().getJoueurCourant().utiliserCarte(((ICarte)o)
					,Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()));
		}
		else {
			
			String chaine2="Quelle carte vises tu ?";
			es.println(chaine2);
			String choix_carte=es.readLine();
			Object cible=(Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()).getCarteEnJeu(choix_carte));
			if(cible==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
			Plateau.instancePlateau().getJoueurCourant().utiliserCarte((ICarte)o, cible);
		}

	}

	@Override
	public String getDescription() {
		return null;
	}

}

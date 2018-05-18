package capacite;

import java.lang.Object;
import Plateau.Plateau;
import application.HearthstoneException;
import joueur.IJoueur;

/**
 * Permet de piocher une ou plusieurs cartes 
 */
public final class Pioche extends ACapacite {
	
	private int nb_pioche ;
	
	public Pioche(int nb){
		super("Pioche" , " La carte qui possede cette capacite permet de piocher une ou plusieurs cartes ");
		this.nb_pioche=nb;
	}
	
	public final void executerEffetMiseEnJeu(Object cible) throws HearthstoneException
	{

		cible=(IJoueur)Plateau.instancePlateau().getJoueurCourant();
		for(int i=0;i<this.nb_pioche;i++)
		{
			((IJoueur) cible).piocher();
		}
	}

	public void executerEffetDebutTour() throws HearthstoneException {}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {}

	public void executerEffetFinTour() throws HearthstoneException {}

	public void executerAction(Object cible) throws HearthstoneException {}

}
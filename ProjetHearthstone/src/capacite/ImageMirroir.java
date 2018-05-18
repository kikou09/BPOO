package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.Serviteur;
import joueur.IJoueur;

/**
 * Capacite propre a Jaina . Invoque au debut du tour deux serviteurs 0/2 avec provocation .
 * @author Jorane
 *
 */
public final class ImageMirroir extends ACapacite{
	
	public ImageMirroir(){
		
		super("Image mirroir ", "Invoque 2 serviteur 0/2 ayant provocation ");
		
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		
		Serviteur s_invoque1= new Serviteur("Serviteur de Jaina", 0 , joueur_courant , 0 , 2 , new Provocation());
		Serviteur s_invoque2= (Serviteur) s_invoque1.clone();
		
		joueur_courant.getCartes_Poses().add(s_invoque1);
		joueur_courant.getCartes_Poses().add(s_invoque2);
	}

	public void executerEffetDebutTour() {}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {}

	public void executerEffetFinTour() throws HearthstoneException {}

	public void executerAction(Object cible) throws HearthstoneException {}


}

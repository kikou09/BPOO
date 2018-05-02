package capacite;

import Plateau.Plateau;
import carte.Serviteur;
import joueur.IJoueur;

public final class ImageMirroir extends ACapacite{
	
	public ImageMirroir(){
		
		super("Image mirroir ", "Invoque 2 serviteur 0/2 ayant provocation ");
		
	}

	@Override
	public void executerAction(Object cible) {
		
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		
		Serviteur s_invoque1= new Serviteur("Serviteur de Jaina", 0 , joueur_courant , 0 , 2 , new Provocation());
		Serviteur s_invoque2= (Serviteur) s_invoque1.clone();
		
		joueur_courant.getCartes_Poses().add(s_invoque1);
		joueur_courant.getCartes_Poses().add(s_invoque2);
	}

	@Override
	public void executerEffetDebutTour() {}

	@Override
	public void executerEffetDisparition(Object cible) {}

	@Override
	public void executerEffetFinTour() {}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {}



}

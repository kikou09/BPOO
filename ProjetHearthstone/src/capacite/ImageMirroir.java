package capacite;

import carte.Serviteur;

public final class ImageMirroir extends ACapacite{
	
	public ImageMirroir(){
		
		super("Image mirroir ", "Invoque 2 serviteur 0/2 ayant provocation ");
		
	}

	@Override
	public void executerAction(Object cible) {
		
		//joueur_courant=Plateau.getJoueurCourant()
		
		//Serviteur s_invoque1= new Serviteur("Serviteur de Jaina", 0 , joueur_courant , 0 , 2 , new Provocation())
		//Serviteur s_invoque2= (Serviteur) s_invoque1.clone();
	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}

}

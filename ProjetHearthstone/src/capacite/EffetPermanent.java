package capacite;

import Plateau.Plateau;
import carte.ICarte;
import carte.Serviteur;
import joueur.IJoueur;

public class EffetPermanent extends ACapacite {
	
	private int vie_bonus;
	private int attaque_bonus;
	
	public EffetPermanent(String n , String d ,int v ,int a) {
			super(n,d);
			this.vie_bonus=v;
			this.attaque_bonus=a;
	}



	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour() {
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		
		for(ICarte c : joueur_courant.getCartes_Poses())
		  {
		 		if ( c instanceof Serviteur){
		 			((Serviteur) c).gagneAttaque(this.attaque_bonus);
		 			((Serviteur) c).gagneVie(this.vie_bonus);
		 		}
		 }
	}
	
	@Override
	public void executerEffetDisparition(Object cible) {		
	}

	public void executerEffetFinTour() {
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		
		 for(ICarte c : joueur_courant.getCartes_Poses())
		 {
		 		if ( c instanceof Serviteur){
		 			((Serviteur)c).gagneAttaque(-this.attaque_bonus);
		 			((Serviteur)c).subitAttaque(this.vie_bonus);
		 		}
		 }
		
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}
}

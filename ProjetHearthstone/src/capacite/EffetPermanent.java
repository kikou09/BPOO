package capacite;

import Plateau.Plateau;
import carte.ICarte;
import carte.Serviteur;
import joueur.IJoueur;
/** 
 * l'activation de cette capacité  gener un bonus (points de vie et d'attaque),
 *  qui est effective sur les serviteurs deja presents sur le plateau.
 *  Les bonus restent meme apres le mort du serviteur qui possede cette capacité.
 */
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

	}
	
	@Override
	public void executerEffetDisparition(Object cible) {
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		
		 for(ICarte c : joueur_courant.getCartes_Poses())
		 {
		 		if ( c instanceof Serviteur){
		 			((Serviteur)c).gagneAttaque(-this.attaque_bonus);
		 			((Serviteur)c).subitAttaque(this.vie_bonus);
		 		}
		 }
	}

	public void executerEffetFinTour() {
		
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		IJoueur joueur_courant=Plateau.instancePlateau().getJoueurCourant();
		for(ICarte c : joueur_courant.getCartes_Poses())
		  {
		 		if ( c instanceof Serviteur){
		 			((Serviteur) c).gagneAttaque(this.attaque_bonus);
		 			((Serviteur) c).gagneVie(this.vie_bonus);
		 		}
		 }
		
		this.utilise=true;
		
	}
}

package capacite;

public class EffetPermanent extends Bonus {
	

	public EffetPermanent(int v ,int a) {
			
			super("Effet Permanent", "Modifie les caracteristiques de tous les serviteurs en jeu"
					+ " en leur ajoutant des points d'attaque et/ou de vie", v ,a);		
	}



	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour() {

	}
//Probleme bonus disparait quand carte disparait
	@Override
	public void executerEffetDisparition(Object cible) {		
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

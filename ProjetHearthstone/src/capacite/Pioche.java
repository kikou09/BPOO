package capacite;

import Plateau.Plateau;

public final class Pioche extends Capacite {
	
	private int nb_pioche ;
	
	public Pioche(int nb){
		super("Pioche" , " La carte qui possède cette capacite permet de piocher une ou plusieurs cartes ");
		this.nb_pioche=nb;
	}
	
	public final void executerAction(Object cible)
	{
		//cible=Plateau.getJoueurCourant();
		for(int i=0;i<this.nb_pioche;i++)
		{
			//cible.piocher();
		}
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
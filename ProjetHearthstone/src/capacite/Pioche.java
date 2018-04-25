package capacite;

import java.lang.Object;
import Plateau.Plateau;
import application.HearthstoneException;
import joueur.IJoueur;

public final class Pioche extends ACapacite {
	
	private int nb_pioche ;
	
	public Pioche(int nb){
		super("Pioche" , " La carte qui possede cette capacite permet de piocher une ou plusieurs cartes ");
		this.nb_pioche=nb;
	}
	
	public final void executerAction(Object cible) throws HearthstoneException
	{

		cible=(IJoueur)Plateau.instancePlateau().getJoueurCourant();
		for(int i=0;i<this.nb_pioche;i++)
		{
			((IJoueur) cible).piocher();
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
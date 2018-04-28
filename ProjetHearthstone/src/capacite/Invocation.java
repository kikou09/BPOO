package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.Serviteur;
import joueur.IJoueur;

public class Invocation extends ACapacite {
	
	private Serviteur serviteur_invoque ;
	
	public Invocation ( String nom , String des , Serviteur s )
	{
		super(nom , des ) ;
		
		if(s==null)
		{
			throw new IllegalArgumentException("Le serviteur ne doit pas être null");
		}
		this.serviteur_invoque=s;
	}
	
	public Serviteur getServiteur_invoque(){
		return this.serviteur_invoque;
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {}

	@Override
	public void executerEffetDebutTour() {}

	@Override
	public void executerEffetDisparition(Object cible) {}

	@Override
	public void executerEffetFinTour() {}

	@Override
	public void executerAction(Object cible) throws HearthstoneException { 
		
		IJoueur proprietaire=Plateau.instancePlateau().getJoueurCourant();
		Serviteur s=(Serviteur)(this.serviteur_invoque.clone());
		s.setProprietaire(proprietaire);
		proprietaire.getCartes_Poses().add(s);
		s.executerEffetDebutMiseEnJeu(null);
		
		
	}

}

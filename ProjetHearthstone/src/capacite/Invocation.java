package capacite;

import Plateau.Plateau;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import carte.Serviteur;
import joueur.IJoueur;

/**
 * Invoque un serviteur au moment de sa mise en jeu
 */
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
	public void executerEffetDebutTour() {}

	@Override
	public void executerEffetDisparition(Object cible) {}

	@Override
	public void executerEffetFinTour() {}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException { 
		
		IJoueur proprietaire=Plateau.instancePlateau().getJoueurCourant();
		Serviteur s=(Serviteur)(this.serviteur_invoque.clone());
		proprietaire.getCartes_Poses().add(s);
		s.setProprietaire(proprietaire);
		s.executerEffetDebutMiseEnJeu(null);
		
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}

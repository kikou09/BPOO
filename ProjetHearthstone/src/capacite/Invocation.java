package capacite;

import carte.Serviteur;

public class Invocation extends Capacite {
	
	private Serviteur serviteur_invoque ;
	
	public Invocation ( String nom , String des , Serviteur s )
	{
		super(nom , des ) ;
		
		if(s==null)
		{
			//throw new ExceptionHearthsone("Le serviteur ne doit pas être null");
			System.out.println("erreur");
		}
		this.serviteur_invoque=s;
	}
	
	public Serviteur getServiteur_invoque(){
		return this.serviteur_invoque;
	}

	@Override
	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
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

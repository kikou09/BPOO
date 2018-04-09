package carte;

import capacite.ACapacite;
import joueur.Joueur;

public final class Serviteur extends Carte {

	private int point_attaque;
	private int point_vie;
	private int attente;
	//private int deja_attaque ???;
	private ACapacite capacite;
	
	public Serviteur( String n , int cout , Joueur j , int attaque , int vie , ACapacite c)
	{
		super(n,cout,j);
		if(vie==0)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Les points de vies ne doivent pas être égales à 0");
		if(attaque==0)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Les points d'attaque ne doivent pas être egales à 0");
		this.point_attaque=attaque;
		this.point_vie=vie;
		this.capacite=c;
	}
	
	public Serviteur ( Serviteur s)
	{
		super(s.getNom() , s.getCout() , s.getProprietaire());
		this.point_attaque=s.getAttaque();
		this.point_vie=s.getVie();
		//this.capacite=s.getCapacite();
	}
	
	public int getAttaque(){
		return this.point_attaque;
	}
	
	public int getVie(){
		return this.point_vie;
	}
	
	public int getAttente() {
		return attente;
	}

	public final void executerAction(Object o){
		if (this.attente !=0)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Impossible de la jouer a� ce tour ci");
	}
	
	public final boolean disparait()
	{
		return this.point_vie <= 0;
	}
	
	public final String toString()
	{
		return " Serviteur [ " + super.toString() + "attaque = " + this.point_attaque + " vie = " + 
				this.point_vie + " ] " ;
	}
	
	public final void subitAttaque ( int degat )
	{
		if(this.point_vie - degat >0)
			this.point_vie = this.point_vie - degat ;
		else
			this.point_vie=0;
	}
	
	public final void gagneVie( int nb)
	{
		this.point_vie = this.point_vie + nb ;
	} 
	
	public final void setAttente(int tour)
	{
		this.attente=tour;
	}
	
	public final Object clone (){
		return new Serviteur(this);
	}
	
	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour(Object cible) {
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

}
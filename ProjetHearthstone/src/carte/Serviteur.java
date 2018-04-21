package carte;

import application.HearthstoneException;
import capacite.ACapacite;
import carte.ICarte;
import capacite.ICapacite;
import joueur.IJoueur;
import joueur.Joueur;

public final class Serviteur extends Carte {

	private int point_attaque;
	private int point_vie;
	private int attente;
	private boolean deja_attaque ;
	private ICapacite capacite;
	
	public Serviteur( String n , int cout , IJoueur j , int attaque , int vie , ICapacite c)
	{
		super(n,cout,j);
		if(vie<=0)
			throw new IllegalArgumentException("Les points de vies doivent etre positif");
		if(attaque==0)
			throw new IllegalArgumentException("Les points d'attaque ne doivent pas être egaaux à  0");
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

	public final void executerAction(Object o) throws HearthstoneException {
		if (this.attente !=0)
			throw new HearthstoneException ("Impossible de la jouer a  ce tour ci");
		if(this.deja_attaque==false)
			throw new HearthstoneException(" Deja joué ");
			
		//if(this.peutAttaquer(o))
			//throw new HearthstoneException("Peut pas attaquer car un serviteur du plateau
			//a provocation");
			
		this.deja_attaque=true;
		
		//o est un joueur
		//o est un serviteur
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
	
	public final void gagneAttaque(int a)
	{
		this.point_attaque+=a;
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
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	/*
	//Verifie si la cible peut être attaquer
	public boolean peutAttaquer(Object cible) {
		
		
	}*/
}
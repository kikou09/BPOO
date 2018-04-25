package carte;

import Plateau.Plateau;
import application.HearthstoneException;
import capacite.ACapacite;
import carte.ICarte;
import capacite.ICapacite;
import capacite.Provocation;
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
		this.capacite=s.getCapacite();
	}
	
	public ICapacite getCapacite() {
		return this.capacite;
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
		if(this.deja_attaque==true)
			throw new HearthstoneException(" Deja joué ");
			
		if(!(this.peutAttaquer(o)))
			throw new HearthstoneException("Peut pas attaquer car un serviteur du plateau a provocation");
		
		if(!(o instanceof IJoueur) && !(o instanceof Serviteur))
			throw new HearthstoneException("Cible pas du bon type");
			
		this.deja_attaque=true;
		
		if(o instanceof IJoueur) {
			((IJoueur) o).getHeros().perteVie(this.point_attaque);
			if(((IJoueur) o).getHeros().estMort())
				Plateau.instancePlateau().gagnePartie(Plateau.instancePlateau().getJoueurCourant());			
		}
		
		if(o instanceof Serviteur) {
			try {
				((Serviteur)o).point_vie=-this.point_attaque;
				if(((Serviteur)o).disparait()) {
					Serviteur s=((Serviteur)o);
					((Serviteur)o).getProprietaire().perdreCarte((ICarte)s);
				}
			}
			catch(HearthstoneException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public final boolean disparait()
	{
		return this.point_vie <= 0;
	}
	
	public final String toString()
	{
		return " Serviteur [ " + super.toString() + "attaque = " + this.point_attaque + " vie = " + 
				this.point_vie + " " +this.capacite + " ] " ;
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
		this.setAttente(1);
		if(this.capacite != null)
			try {
				this.capacite.executerAction(cible);
			}
			catch(HearthstoneException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		if(this.capacite!=null)
			this.capacite.executerEffetFinTour();
	}

	@Override
	public void executerEffetDebutTour() {
		this.deja_attaque=false;
		if(this.attente>0)
			this.attente--;
		if(this.capacite != null)
			this.capacite.executerEffetDebutTour();
		
	}

	
	//Verifie si la cible peut être attaquer
	public boolean peutAttaquer(Object cible) {
		if(cible instanceof Serviteur && ((Serviteur)cible).capacite instanceof Provocation)
			return true;
		try {
			for(ICarte c : Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()).getCartes_Poses())
			{
				if(c instanceof Serviteur)
					if(((Serviteur)c).capacite instanceof Provocation)
						return false;
			}
		}
		catch(HearthstoneException e) {
			e.printStackTrace();
		}
		
		return true;
	}
		
}
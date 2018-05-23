package carte;

import Plateau.Plateau;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import carte.ICarte;
import capacite.ICapacite;
import capacite.Provocation;
import joueur.IJoueur;

/**
 * Un serviteur possède une capacite , qui est executé au moment de la mise en jeu
 * il doit attendre un tour avant de pouvoir attaquer 
 * @author Jorane SCHUSTER , Claire MICHALON
 *
 */
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
	
	/**
	 * Getter pour la capacite du serviteur
	 * @return capacite
	 */
	public ICapacite getCapacite() {
		return this.capacite;
	}

	/**
	 * Getter pour les points d'attaques
	 * @return un entier
	 */
	public int getAttaque(){
		return this.point_attaque;
	}
	
	
	/**
	 * Getter pour les points de vies
	 * @return un entier
	 */
	public int getVie(){
		return this.point_vie;
	}
	
	/**
	 * Getter pour le nombre de tour a attendre avant de pouvoir attaquer
	 * @return un entier
	 */
	public int getAttente() {
		return attente;
	}

	/**
	 * Un serviteur peut avoir une action qui se commande à n'importe quel moment du tour lorsqu'elle est en jeu
	 * @throws HearthstoneException :
	 * 						si l'attente est >0 (il ne peut pas attaquer lors de ce tour 
	 * 						si le serviteur a deja attaqué à ce tour ci
	 * 						si il tente d'attaquer un serviteur et qu'un autre possède la capacite Provocation
	 * 						si la cible n'est pas du bon type
	 * @see peutAttaquer(cible)
	 * 
	 */
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
				
				this.point_vie-=((Serviteur)o).point_attaque;
				if(this.disparait())
					this.getProprietaire().perdreCarte(this);
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
		String chaine= " Serviteur [ " + super.toString() + "attaque = " + this.point_attaque + " vie = " + 
				this.point_vie + " " +this.capacite + " ] " ;
		if(this.attente==0)
			chaine+="(jouable)";
		else
			chaine+="(non jouable)";
		
		return chaine;
	}
	
	/**
	 * Le serviteur subit une attaque et ses points de vies diminuent en fonction de degat
	 * @param degat
	 */
	public final void subitAttaque ( int degat )
	{
		if(this.point_vie - degat >0)
			this.point_vie = this.point_vie - degat ;
		else
			this.point_vie=0;
	}
	
	
	/**
	 * Le serviteur gagne des points d'attaques (bonus par exemple)
	 * @param a : nb de points d'attaques en plus
	 */
	public final void gagneAttaque(int a)
	{
		this.point_attaque+=a;
	}
	
	
	/**
	 * Le serviteur gagne des points de vies (bonus)
	 * @param nb : points de vies bonus
	 */
	public final void gagneVie( int nb)
	{
		this.point_vie = this.point_vie + nb ;
	} 
	
	/**
	 * Setter pour le nombre de tour a attendre avant de pouvoir attaquer
	 * @param tour
	 */
	public final void setAttente(int tour)
	{
		this.attente=tour;
	}
	
	public final Object clone (){
		return new Serviteur(this);
	}
	
	/**
	 * Un serviteur peut avoir un effet au début de sa mise en jeu
	 * Execute la capacite du serviteur et met l'attente à 1 
	 * @param cible sur laquelle executer la capacite
	 * @throws HearthstoneCapaciteException :
	 * 				- si la capacite a besoin d'une cible mais qu'elle est nulle 
	 * @throws HearthstoneException 
	 */
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneCapaciteException, HearthstoneException {
		this.setAttente(1);
		if(this.capacite != null)
			try {
				
				this.capacite.executerEffetMiseEnJeu(cible);
			}
			catch(HearthstoneCapaciteException e) {
				e.printStackTrace();
			}
		
	}

	
	/**
	 * Un serviteur peut avoir un effet au moment de sa disparition du jeu
	 */
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		if(this.capacite!=null)
			this.capacite.executerEffetDisparition(cible);
		
	}

	/**
	 * Un serviteur peut avoir un effet à la fin d'un chaque tour où elle est en jeu
	 */
	public void executerEffetFinTour() throws HearthstoneException {
		if(this.capacite!=null)
			this.capacite.executerEffetFinTour();
	}

	/**
	 * Execute l'effet de debut de tour de la capacite du serviteur  
	 * @throws HearthstoneException 
	*/
	public void executerEffetDebutTour() throws HearthstoneException {
		this.deja_attaque=false;
		if(this.attente>0)
			this.attente--;
		if(this.capacite != null)
			this.capacite.executerEffetDebutTour();
		
	}

	
	/**
	 * Verifie si un serviteur adverse en jeu possède la capacite provocation 
	 * @param cible : serviteur adverse ciblé
	 * @return boolean : true si le serviteur peut attaquer la cible choisie , false sinon
	 */
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
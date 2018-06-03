package heros;

import java.util.ArrayList;

import capacite.ICapacite;
import carte.ICarte;


/**
 * Tout joueur possède un héros qui le representera lors du joueur
 * Si le Heros meurt , le joueur perd
 * @author Jorane SCHUSTER , Claire MICHALON
 *
 */
public final class Heros implements Cloneable{

	private String nom ;
	private int pt_vie;
	private int vie_max;
	private ArrayList<ICarte> cartes ;
	private ICapacite pouvoir ; 

	public Heros(String n , ICapacite p) {
		if (n==null)
			throw new IllegalArgumentException("Le nom ne doit pas être null");
		if(p==null)
			throw new IllegalArgumentException("La capacité de doit pas être null");
		if(n.equals(""))
			throw new IllegalArgumentException("Le nom ne doit pas être vide");
		this.nom=n;
		this.pt_vie=15;
		this.vie_max=15;
		this.pouvoir=p;
		this.cartes=new ArrayList <ICarte>();
	}
	
	public Heros (String n )
	{
		if(n==null)
			throw new IllegalArgumentException("Le nom ne doit pas être null");
		if(n.equals(""))
			throw new IllegalArgumentException("Le nom ne doit pas être vide");
		this.nom=n;
		this.pt_vie=15;
		this.vie_max=15;
		this.cartes=new ArrayList <ICarte>();
		this.pouvoir=null;
	}
	
	public Heros( Heros h){
		this.nom=h.nom;
		this.pt_vie=h.pt_vie;
		this.vie_max=h.vie_max;
		this.pouvoir=h.pouvoir;
		this.cartes=h.cartes;
	}
	
	
	/**
	 * Getter pour le nom du Heros
	 * @return chaine de caractères
	 */
	public String getNom (){
		return this.nom;
	}
	
	/**
	 * Getter pour le pouvoir du heros
	 * @return capacite
	 */
	public ICapacite getPouvoir () {
		return this.pouvoir;
	}
	
	/**
	 * Getter pour les points de vies du heros
	 * @return entier
	 */
	public int getPointsDeVie () {
		return this.pt_vie;
	}

	
	/**
	 * Le héros perd des points de vies 
	 * @param nb de points de vies qu'il perd
	 */
	public void perteVie(int nb){
		this.pt_vie=this.pt_vie - nb;
	}
	
	
	/**
	 * @return vrai si le héros est mort
	 */
	public boolean estMort(){
		return this.pt_vie <= 0;
	}
	
	protected Object clone()
	{
		return new Heros (this);
	}
	
	public String toString(){
		String chaine= this.nom + " , point de vie = " + this.pt_vie + "]" ;
		
		if(this.pouvoir!=null)
			chaine+= "\n\t    pouvoir = " + this.pouvoir;
		return chaine;
	}
	

	/**
	 * Getter pour les cartes appartenant au heros
	 * @return ArrayList de cartes
	 */
	public ArrayList<ICarte> getCartes() {
		return cartes;
	}

	/**
	 * Setter pour les cartes du heros
	 * @param cartes ArrayList contenat les cartes du hero
	 */
	public void setCartes(ArrayList<ICarte> cartes) {
		if(cartes==null)
			throw new IllegalArgumentException("Les cartes ne doivent pas être nulles");
		this.cartes = cartes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heros other = (Heros) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pt_vie != other.pt_vie)
			return false;
		return true;
	}
	


}
package heros;

import java.util.ArrayList;

import capacite.ICapacite;
import carte.ICarte;

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
	
	public String getNom (){
		return this.nom;
	}
	
	public ICapacite getPouvoir () {
		return this.pouvoir;
	}
	
	public int getPointsDeVie () {
		return this.pt_vie;
	}
	
	public void perteVie(int nb){
		this.pt_vie=this.pt_vie - nb;
	}
	
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
	

	public ArrayList<ICarte> getCartes() {
		return cartes;
	}

	public void setCartes(ArrayList<ICarte> cartes) {
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
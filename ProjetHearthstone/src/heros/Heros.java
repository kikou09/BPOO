package heros;

import java.util.ArrayList;
import carte.Carte;

public final class Heros implements Cloneable{

	private String nom ;
	private int pt_vie;
	private int vie_max;
	private int jouer; 
	private static ArrayList<Heros> listeHeros ;
	private ArrayList<Carte> cartes ;
	//private Capacite pouvoir ; 
/*	
	public static Heros choixHeros(String nom)
	{
		
		if(listeHeros==null)
			listeHeros=new ArrayList<Heros>();
		if(listeHeros.size()==0)
		{
			Heros Rexxar= new Heros("Rexxar");
			Heros Jaina= new Heros ("Jaina");
			
			listeHeros.add(Rexxar);
			listeHeros.add(Jaina);
			System.out.println(listeHeros);
			
		}
		
		boolean trouve=false;
	    for( Heros o : listeHeros)
	    {
	    	if( o.getNom().equals(nom))
		   	{
		   		trouve=true;
		   		Object h = o.clone();
		   		Heros heros_demande=(Heros)h;
	    	}
	    }
	    if (!trouve)
	    	System.out.println("Erreur");
			//throw new ExceptionHearthsone("Ce heros n'existe pas ");
	    return heros_demande;
	}	*/
	
	/*public Heros(String n , Capacite p) {
		if (n==null)
			throw new ExceptionHearthsone("Le nom ne doit pas être null");
		if(p==null)
			throw new ExceptionHearthsone("La capacité de doit pas être null");*/
		/*if(n=="")
			throw new ExceptionHearthsone("Le nom ne doit pas être vide");
		this.nom=n;
		this.pt_vie=15;
		this.vie_max=15;
		this.pouvoir=p;
	}*/
	
	public Heros (String n )
	{
		if(n==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le nom ne doit pas être null");
		if(n.equals(""))
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le nom ne doit pas être vide");
		this.nom=n;
		this.pt_vie=15;
		this.vie_max=15;
		this.cartes=new ArrayList <Carte>();
		//this.pouvoir=null;
	}
	
	public Heros( Heros h){
		this.nom=h.nom;
		this.pt_vie=h.pt_vie;
		this.vie_max=h.vie_max;
		//this.pouvoir=h.pouvoir;
	}
	
	public String getNom (){
		return this.nom;
	}
	
	/*public ICapacite getPouvoir () {
		return this.pouvoir;
	}*/
	
	public int GetPointsDeVie () {
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
		return " Heros [ nom = " + this.nom + " , point de vie = " + this.pt_vie + " ]" ;
	}
	

	public ArrayList<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(ArrayList<Carte> cartes) {
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
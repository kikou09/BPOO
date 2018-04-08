package carte ;
import joueur.Joueur;

public abstract class Carte implements ICarte{

	private String nom;
	private int cout_mana;
	private Joueur proprietaire;
	
	public Carte(String n, int c , Joueur j)
	{
		if(n==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le nom ne doit pas etre null");
		if(n=="")
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le nom ne doit pas etre vide");
		this.nom=n;
		
		if(c<0)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le cout en mana doit etre positif ");	
		this.cout_mana=c;
		this.proprietaire=j;
	}
	
	public final String getNom(){
		return this.nom;
	}
	
	public final int getMana(){
		return this.cout_mana;
	}
	
	public final Joueur getProprietaire(){
		return this.proprietaire;
	}
	
	
	public void setProprietaire(Joueur j){
		this.proprietaire=j;
	}
	
	public int getCout() {
		return cout_mana;
	}

	public void setCout_mana(int cout_mana) {
		this.cout_mana = cout_mana;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString(){
		return "Carte [ Nom = " + this.nom + " Cout = " + this.cout_mana + "]" ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (cout_mana != other.cout_mana)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}		
			
}		



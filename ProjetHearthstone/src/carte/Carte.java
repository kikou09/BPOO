package carte ;
import joueur.IJoueur;

/**
 * Classe qui implémente l'interface ICarte
 *
 */
public abstract class Carte implements ICarte{

	private String nom;
	private int cout_mana;
	private IJoueur proprietaire;
	
	public Carte(String n, int c , IJoueur j)
	{
		if(n==null)
			throw new IllegalArgumentException("Le nom ne doit pas etre null");
		if(n=="")
			throw new IllegalArgumentException("Le nom ne doit pas etre vide");
		this.nom=n;
		
		if(c<0)
			throw new IllegalArgumentException("Le cout en mana doit etre positif ");	
		this.cout_mana=c;
		this.proprietaire=j;
	}
	
	public final String getNom(){
		return this.nom;
	}
	
	public final int getMana(){
		return this.cout_mana;
	}
	
	public final IJoueur getProprietaire(){
		return this.proprietaire;
	}
	
	
	public void setProprietaire(IJoueur proprietaire){
		this.proprietaire=proprietaire;
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
		return "Carte [ " + this.nom + " cout = " + this.cout_mana + " "  ;
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



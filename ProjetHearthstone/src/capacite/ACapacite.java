package capacite;

/**
 * C'est la classe abstraite de base des capacites qui va etre etendue par d'autres
 * Une capacite peut faire differentes choses et toutes les capacites ont leur propre comportement
 */

public abstract class ACapacite implements ICapacite {
	private String nom;
	private String description;
	protected boolean utilise ;
	
	
	public ACapacite(String n, String d){
		if(n==null)
			throw new IllegalArgumentException("Le nom de la capacite ne doit pas etre null ");
		if(d==null)
			throw new IllegalArgumentException("Il faut une description ");
		this.nom=n;
		this.description=d;
		this.utilise=false;
	}
	
	/**
	 * Le nom de la capacité 
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * La description de la capacité
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Le booleen pour savoir si la capacite a deja ete utlisée ou pas
	 */
	public boolean getUtilise() {
		return utilise;
	}

	public void setUtilise(boolean utilise) {
		this.utilise = utilise;
	}


	public String toString()
	{
		return "Capacite [ " + this.nom + " , " + this.description + "]";
	}
	
}
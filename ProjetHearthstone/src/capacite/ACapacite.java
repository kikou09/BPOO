package capacite;

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
	
	
	public String getNom() {
		return this.nom;
	}
	
	
	public String getDescription() {
		return description;
	}

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
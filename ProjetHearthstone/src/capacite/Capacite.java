package capacite;

public abstract class Capacite implements ICapacite {
	private String nom;
	private String description;
	int utilise ;
	int degats ;
	
	public Capacite(String n, String d){
		if(n==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le nom de la capacité ne doit pas être null ");
		if(d==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Il faut une description ");
		this.nom=n;
		this.description=d;
		this.degats=0;
		this.utilise=0;
	}
	
	public Capacite(String n, String d, int deg ){
		if(n==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le nom de la capacité ne doit pas être null ");
		if(d==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Il faut une description ");
		this.nom=n;
		this.description=d;
		this.degats=deg;
		this.utilise=0;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	
	public String getDescription() {
		return description;
	}

	public int getUtilise() {
		return utilise;
	}

	public void setUtilise(int utilise) {
		this.utilise = utilise;
	}

	public int getDegats() {
		return degats;
	}

	public String toString()
	{
		return "Capacite [nom=" + this.nom + ", description=" + this.description + "]";
	}
	
}
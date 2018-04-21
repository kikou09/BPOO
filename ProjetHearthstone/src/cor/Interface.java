package cor;

import dessin.Dessin;

public abstract class Interface {
	
	private Interface suivant=null;
	
	public Interface(Interface suivant){
		
		this.suivant=suivant;
	}
	
	public Interface getSuivant() {
		return this.suivant;
	}
	
	public abstract boolean saitInteragir(String choix);
	public abstract void executerInteraction(Dessin d);
	public abstract String getDescription();
	
	public void interagir(String choix , Dessin d) throws Exception{
		
		if(saitInteragir(choix))
			executerInteraction(d);
		else if(suivant != null)
			suivant.interagir(choix, d);
		else 
			throw new Exception("pas d'intercation pour"+choix);
	}

	//public void executerInteraction(Dessin d) {}

}

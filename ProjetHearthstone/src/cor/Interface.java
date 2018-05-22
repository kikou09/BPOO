package cor;

import application.HearthstoneCapaciteException;
import application.HearthstoneException;

public abstract class Interface {
	
	private Interface suivant=null;
	
	public Interface(Interface suivant){
		
		this.suivant=suivant;
	}
	
	public Interface getSuivant() {
		return this.suivant;
	}
	
	public abstract boolean saitInteragir(Object choix);
	public abstract void executerInteraction(Object o) throws HearthstoneException, HearthstoneCapaciteException;
	public abstract String getDescription();
	
	public void interagir(Object choix , Object o) throws Exception{
		
		if(saitInteragir(choix))
			executerInteraction(o);
		else if(suivant != null)
			suivant.interagir(choix , o);
		else 
			throw new Exception("pas d'intercation pour"+choix);
	}

	//public void executerInteraction(Dessin d) {}

}

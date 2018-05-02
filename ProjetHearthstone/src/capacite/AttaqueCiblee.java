package capacite;

import java.lang.String;
import java.lang.Object;
import joueur.IJoueur;
import joueur.Joueur;
import Plateau.Plateau;
import application.HearthstoneException;
import carte.Carte;
import carte.ICarte;
import carte.Serviteur;

public class AttaqueCiblee extends Capacite {
	
	public AttaqueCiblee(String n , String des , int d) {
		
		super(n,des,d);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		
		if(cible==null) {
			throw new HearthstoneException("Il faut une cible ");
		}	
		if(this.utilise) {
			throw new HearthstoneException("Capacite deja utilise ");
		}
		
		if(!(cible instanceof IJoueur) && !(cible instanceof Serviteur)) {
			throw new HearthstoneException(" Vous devez attaquer le joueur ou un serviteur ");
		}
		
		if(getServiteurProvocation(cible))
			throw new HearthstoneException("Un serviteur possede Provocation");
		
		if(cible instanceof IJoueur) {
		
			System.out.println("ok2");
			cible=((IJoueur)cible);
			((IJoueur)cible).getHeros().perteVie(this.degats);
		
			if(((IJoueur)cible).getHeros().estMort()) {
				Plateau.instancePlateau().gagnePartie(Plateau.instancePlateau().getJoueurCourant());
			}
		
			
		}
		
		if(cible instanceof Serviteur)
		{
			cible=((Serviteur)cible);
			((Serviteur)cible).subitAttaque(this.degats);
			if(((Serviteur)cible).disparait()){
				((Serviteur)cible).getProprietaire().perdreCarte(((Carte)cible));
			}
			
		}
		
		this.utilise=true;
	}
	
	//Verifie si le joueur adverse possède un serviteur different de la cible avec provocation
	private boolean getServiteurProvocation(Object cible) throws HearthstoneException {
		
		IJoueur adversaire=Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant());

		for(ICarte c : adversaire.getCartes_Poses()) {
			
			if(c instanceof Serviteur)
				if(!(c.equals((Serviteur)cible)) && c.getCapacite() instanceof Provocation)
						return true;
		}
		
		return false;
		
	}

}

package capacite;

import java.lang.String;
import java.lang.Object;
import joueur.IJoueur;
import Plateau.Plateau;
import application.HearthstoneCapaciteException;
import application.HearthstoneException;
import carte.Carte;
import carte.ICarte;
import carte.Serviteur;

/**
 * Capacite qui attaque une cible , soit le héros , soit l'un des serviteurs . Capacite
 * sensible a la provocation
 *
 */
public class AttaqueCiblee extends Capacite {
	
	public AttaqueCiblee(String n , String des , int d) {
		
		super(n,des,d);
	}
	
	/**
	 * Execute l'Effet de Mise En Jeu
	 * @param cible
	 * @return none
	 * @throws HearthstoneException : si la cible est nulle, 
	 * 								  si la capacité mise en jeu est deja utilisée, 
	 * 								  si la cible n'est pas du bon type,
	 * 								  si un serviteur adverse a la capacité "provocation".
	 * @throws HearthstoneCapaciteException 
	 * @see getServiteurProvocation
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException, HearthstoneCapaciteException {
		
		if(cible==null) {
			throw new HearthstoneCapaciteException("Il faut une cible ");
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
	
	/**
	 * Verifie si le joueur adverse possède un serviteur different de la cible avec provocation
	 * @param cible
	 * @return boolean si au moins une des cartes de joueur adverse a provocation
	 * @throws HearthstoneException : @see class Plateau
	 */
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

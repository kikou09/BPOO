package capacite;

import carte.Serviteur;
import heros.Heros;
import joueur.Joueur;
public class AttaqueDuHeros extends Capacite {
	
	public AttaqueDuHeros(String n , String des , int d) {
	
		super(n,des,d);
	}
	
	public void executerAction(Object cible) {
		
		if(cible==null) {
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Il faut une cible ");
		}	
		if(this.utilise==1) {
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Deja utilise ");
		}
		
		if(!(cible instanceof Joueur)) {
			//throw new ExceptionHearthsone(" Vous devez attaquer le joueur adverse ");
		}
		
		//Joueur j_courant= Plateau.getJoueurCourant();
		//Joueur adverse=Plateau.getAdversaire(j_courant);
		//adverse.getHeros().perteVie(this.degats);
		//if(adverse.getHeros().estMort()){
			//Plateau.gagnePartie(j_courant);
		/* ou  
		cible=((Joueur)cible);
		((Joueur)cible).getHeros().perteVie(this.degats);
		
		if(((Joueur)cible).getHeros().estMort()) {
			//Plateau.gagnePartie(Plateau.getJoueurCourant());
		}*/
		
	}

}

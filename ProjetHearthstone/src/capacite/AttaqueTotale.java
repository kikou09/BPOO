package capacite;

import java.util.ArrayList;

import carte.Serviteur;

public class AttaqueTotale extends Capacite {
	
	public AttaqueTotale(String n , String des , int d) {
		
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
		
		//cible=Plateau.getAdversaire(Plateau.gejoueurCourant());
		
		//ArrayList<Carte> cartes_adverses=cible.getCartesPoses();
		
		/*for(Carte c : cartes_adverses){
		 	if(c instanceof Serviteur){
		 	
		 		Serviteur s=((Serviteur)c);
		 		s.subitDegats(this.degats);
		 		if(s.estMort()))
		 			((Joueur)cible).perdreCarte(s);
		 		}
		 	}
		 */
		
		this.utilise=1;
	}
}

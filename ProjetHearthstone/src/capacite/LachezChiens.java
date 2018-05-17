package capacite;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.Carte;
import carte.ICarte;
import carte.Serviteur;
import joueur.IJoueur;

/**
 * 
 * Invoque des chiens (serviteurs) qui possèdent la capacité Charge
 *
 */
public class LachezChiens extends Invocation {

	
	public LachezChiens() {
		
		super("Invocation des chiens ", "Invoque autant de chiens que de serviteurs adverses" , new Serviteur("Chien" ,  0 , null , 1 ,1, new Charge()));
	}
	
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		IJoueur joueur=Plateau.instancePlateau().getJoueurCourant();
		IJoueur adversaire=Plateau.instancePlateau().getAdversaire(joueur);
		
		
		 int nb_serviteurs=0;
		 for ( ICarte c : adversaire.getCartes_Poses())
		 {
		 	if(c instanceof Serviteur)
		 		nb_serviteurs++;
		 }
		 
		 for(int i=0;i<nb_serviteurs;i++)
		 {
		 	Serviteur s = (Serviteur) getServiteur_invoque().clone();
			s.setProprietaire(joueur);
		 	s.setNom(s.getNom() + " " + i+1);
		 	joueur.getCartes_Poses().add(s);
	
		}
	}
}


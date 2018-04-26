package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import carte.ICarte;
import joueur.IJoueur;

public class InterfaceUtiliserPouvoir extends Interface {

	public InterfaceUtiliserPouvoir(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof String))
			return false;
		return getDescription().equals(choix);
	}

	//Retourne la cible 
	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		
		Console es=new Console();
		Object cible;
		
		String chaine="Que vises tu ?";
		chaine+="\n1. Le h�ros";
		chaine+= "\n 2.Une carte \n"; 
		es.println(chaine);
		
		int choix=es.readInt();
		IJoueur adversaire=Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant());
		try {
			if(choix==1) {
				Plateau.instancePlateau().getJoueurCourant().utiliserPouvoir(adversaire);
			}
			else {
				String chaine2="Quelle carte vises tu ?";
				es.println(chaine2);
				String nom_carte=es.readLine();
				cible=adversaire.getCarteEnJeu(nom_carte);
				if(cible==null)
					throw new HearthstoneException("L'adversaire n'a pas cette carte en jeu");
			Plateau.instancePlateau().getJoueurCourant().jouerCarte((ICarte)o, cible);
			}
			
		}
		catch(HearthstoneException e) {
			
			es.println(e.getMessage());
		}
		
	}

	@Override
	public String getDescription() {
		return "Utiliser le pouvoir du h�ros ";
	}

}

package cor;

import Plateau.Plateau;
import application.HearthstoneException;
import capacite.Chasseur;
import carte.ICarte;
import carte.Sort;

public class InterfaceChasseur extends Interface {

	public InterfaceChasseur(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(Object choix) {
		if(!(choix instanceof Sort))
			return false;
		if(!(((Sort)choix).getCapacite() instanceof Chasseur))
			return false;
		return true;
	}

	@Override
	public void executerInteraction(Object o) throws HearthstoneException {
		Console es=new Console();
		
		if(Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()).getCartes_Poses().size()==0)
			throw new HearthstoneException("L'adversaire n'a pas de carte en jeu");
		
		String chaine="Quel serviteur attaquer ?";
		es.println(chaine);
		
		String choix_carte=es.readLine();
		ICarte carte=Plateau.instancePlateau().getAdversaire(Plateau.instancePlateau().getJoueurCourant()).getCarteEnJeu(choix_carte);
		try {
			if(carte==null)
				throw new HearthstoneException("Cette carte n'est pas en jeu");
	
		}
		catch(HearthstoneException e) {
			es.println(e.getMessage());
		}
		
		Plateau.instancePlateau().getJoueurCourant().jouerCarte(((ICarte)o), carte);
		
	}

	

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}

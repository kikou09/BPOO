package joueur;
import joueur.Joueur;
import carte.Carte;
import carte.ICarte;

import java.util.ArrayList;

import Plateau.Plateau;
import application.HearthstoneException;
import heros.Heros;

public final class Joueur implements IJoueur {
	

	private String pseudo;
	private int mana;
	private int stockMana;
	private Heros heros;
	private ArrayList<ICarte> deck;
	private ArrayList<ICarte> main ;
	private ArrayList<ICarte> cartes_poses;
	private boolean joue;
	
	
	public Joueur ( String p , Heros h ){
		if (h==null)
			throw new IllegalArgumentException("Le heros ne doit pas être null ");
		if (p==null)
			throw new IllegalArgumentException("Le pseudo ne doit pas être null");
		if(p.equals(""))
			throw new IllegalArgumentException("Le pseudo ne doit pas être vide");
		this.pseudo=p;
		this.heros=h;
		this.mana=0;
		this.stockMana=0;
		this.main=new ArrayList<ICarte>();
		this.cartes_poses=new ArrayList<ICarte>();
		this.deck=new ArrayList<ICarte>();
		
	}
	
	public final String getPseudo() {
		return this.pseudo;
	}
	
	public final Heros getHeros(){
		return this.heros ;
	}
		
	public final ArrayList<ICarte> getMain(){
		return this.main;
	}
	
	public final int getMana() {
		return this.mana;
	}
	
	public final int getStockMana () {
		return this.stockMana;
	}
	
	public ArrayList<ICarte> getDeck() {
		return deck;
	}
	

	public void setDeck(ArrayList<ICarte> d) throws HearthstoneException {
		
		if(Plateau.instancePlateau().estDemarree())
			throw new HearthstoneException("La partie est en cours ");
		if(d==null)
			throw new HearthstoneException("Le deck a ajouter ne doit pas être null");
		this.deck=d;

	}

	public final ArrayList<ICarte> getCartes_Poses() {
		return cartes_poses;
	}
	

	public final String toString()
	{
		return this.pseudo + " [ Heros = " + this.heros +  " \n\t    Stock de mana =" + this.stockMana + "\n";
	}
	
	public final void prendreTour() throws HearthstoneException {
		if(this.joue)
			throw new HearthstoneException ("Tu as deja le tour ");
		this.joue=true;
		if (this.mana < IJoueur.MAX_MANA)
			mana++;
		this.stockMana=this.mana;
		piocher();
		this.joue=true;
		Plateau.instancePlateau().setJoueurCourant(this);
		if(this.heros.getPouvoir() != null)
			this.heros.getPouvoir().executerEffetDebutTour();
		
		for (ICarte carte : cartes_poses) {
			
			carte.executerEffetDebutTour();	
		}
		
	}
		
	public final void finirTour () throws HearthstoneException {
		System.out.println(this.joue);
		if(!this.joue)
			throw new HearthstoneException ("Ce n'est pas ton tour ");
		for(ICarte c : this.cartes_poses)
		{
			c.executerEffetFinTour();
		}
		
		this.joue=false;
		Plateau.instancePlateau().finTour(this);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IJoueur other = (IJoueur) obj;
		if (mana != other.getMana())
			return false;
		if (pseudo == null) {
			if (other.getPseudo() != null)
				return false;
		} else if (!pseudo.equals(other.getPseudo()))
			return false;
		return true;
	}
	
	
	
	public final void piocher()  throws HearthstoneException {
		if(this.deck.size()!=0 )
		{
			int i = (int)(Math.random() * this.deck.size());
			ICarte carte_p = this.deck.get(i);
			this.main.add(carte_p);
			this.deck.remove(i);
		}
	}
	
	
	public final void jouerCarte(ICarte carte) throws HearthstoneException {
		if (!this.main.contains(carte))
			throw new HearthstoneException("Tu n'as pas cette carte dans ta main ! ");
		if(mana<carte.getMana())
			throw new HearthstoneException("Tu n'as pas assez de mana");
		this.mana=this.mana - carte.getMana();
		this.main.remove(carte);
		this.cartes_poses.add(carte);
		try {
			
			carte.executerEffetDebutMiseEnJeu(null);
		}
		catch(HearthstoneException e) {
			
			this.mana=this.mana + carte.getMana();
			this.main.add(carte);
			this.cartes_poses.remove(carte);
			throw new HearthstoneException (e.getMessage());
		}
	}
	
	public final void jouerCarte(ICarte carte, Object cible) throws HearthstoneException{
		if (!this.main.contains(carte))
			throw new HearthstoneException("Tu n'as pas cette carte dans ta main ! ");
		if(mana<carte.getMana())
			throw new HearthstoneException("Tu n'as pas assez de mana");
		this.mana=this.mana - carte.getMana();
		this.main.remove(carte);
		this.cartes_poses.add(carte);
		try {
			
			carte.executerEffetDebutMiseEnJeu(cible);
		}
		catch(HearthstoneException e) {
			
			throw new HearthstoneException ("Erreur de cible");
		}
	}

	public final void perdreCarte(ICarte carte) throws HearthstoneException{
		if (!this.cartes_poses.contains(carte))
			throw new HearthstoneException("Carte non posees sur le plateau");
		this.cartes_poses.remove(carte);
	}
	
	
	public final void utiliserPouvoir(Object cible) throws HearthstoneException{
		System.out.println("ok");
		if(this.heros.getPouvoir()==null)
			throw new HearthstoneException("Ton heros ne possede pas de pouvoir ");
		this.heros.getPouvoir().executerAction(cible);
	}
	
	
	public final ICarte getCarteEnJeu(String nomCarte)
	{
		for(ICarte c: this.cartes_poses) {
			
			if(c.getNom().contains(nomCarte))
			{
				return c;
			}
			
		}
		
		return null;
		
	}
	public final ICarte getCarteEnMain(String nomCarte)
	{
		for(ICarte c : this.main) {
			
			if(c.getNom().contains(nomCarte))
				return c;
		}
		
		return null;
		
	}

	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		
		if (!this.cartes_poses.contains(carte))
			throw new HearthstoneException("Carte non posees sur le plateau");
		carte.executerAction(cible);
		if (carte.disparait())
			this. cartes_poses.remove(carte);
		
	}

	
}
package joueur;
import joueur.Joueur;
import carte.Carte;

import java.util.ArrayList;

import Plateau.Plateau;
import heros.Heros;

public final class Joueur implements IJoueur {
	
	public static int MAX_MANA=10;
	public static int TAILLE_DECK=15;
	
	private String pseudo;
	private int mana;
	private int stockMana;
	private Heros heros;
	private ArrayList<Carte> deck;
	private ArrayList<Carte> main ;
	private ArrayList<Carte> cartes_poses;
	private boolean joue;
	
	
	public Joueur ( String p , Heros h ){
		if (h==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le heros ne doit pas être null ");*/
		if (p==null)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le pseudo ne doit pas être null");
		if(p=="")
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Le pseudo ne doit pas être vide");
		this.pseudo=p;
		this.heros=h;
		this.mana=0;
		this.main=new ArrayList<Carte>();
		this.cartes_poses=new ArrayList<Carte>();
		this.deck=new ArrayList<Carte>();
		
	}
	
	public final String getPseudo() {
		return this.pseudo;
	}
	
	public final Heros getHeros(){
		return this.heros ;
	}
		
	public final ArrayList<Carte> getMain(){
		return this.main;
	}
	
	public final int getMana() {
		return this.mana;
	}
	
	public final int getStockMana () {
		return this.stockMana;
	}
	
	public ArrayList<Carte> getDeck() {
		return deck;
	}
	

	public void setDeck(ArrayList<Carte> d) {
		
		if(d!=null)
		{
			//test si la partie est en cours
			this.deck=d;
		}
	}

	public ArrayList<Carte> getCartes_poses() {
		return cartes_poses;
	}

	public final String toString()
	{
		return "Joueur [pseudo=" + this.pseudo + " , Heros = " + this.heros +  ", mana=" + this.mana + ", Stock de mana =" + this.stockMana + "]"; 
	}
	
	public final void prendreTour() {//throws jeu.ExceptionHearthstone {
		if(this.joue)
			System.out.println("erreur");  
			//throw new ExceptionHearthsone ("Tu as deja le tour ");
		this.joue=true;
		if (this.mana < Joueur.MAX_MANA)
			mana++;
		this.stockMana=this.mana;
		/*if(this.heros.getPouvoir() != null)
			//il peut executer son pouvoir*/
		
	}
		
	public final void finirTour () {//throws jeu.ExceptionHearthstone{
		if(!this.joue)
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Ce n'est pas ton tour ");
		for(Carte c : this.cartes_poses)
		{
			c.executerEffetFinTour();
		}
		
		this.joue=false;
		//Plateau.finTour(this);
	}


	@Override
	public void utiliserPouvoir(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (mana != other.mana)
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		return true;
	}
	
	
	
	public final void piocher() { //throws jeu.ExceptionHearthstone{
		if(this.deck.size()!=0 && this.deck.size() < Joueur.TAILLE_DECK)
		{
			int i=1;
			i = (int)(Math.random() * i);
			System.out.println(i);
			Carte carte_p = this.deck.get(i);
			this.main.add(carte_p);
			this.deck.remove(i);
		}
	}
	
	/*
	public final void jouerCarte(ICarte carte)throws jeu.ExceptionHearthstone{
		if (!this.main.contains(carte))
			throw new ExceptionHearthsone("Tu n'as pas cette carte dans ta main ! ");
		if(mana<carte.getMana())
			throw new ExceptionHearthsone("Tu n'as pas assez de mana");
		this.mana=this.mana - carte.getMana()
		this.main.remove(carte);
		this.cartes_posés.add(carte);
		//Test action sans cible
	}
	
	public final void jouerCarte(ICarte carte, java.lang.Object cible)throws jeu.ExceptionHearthstone{
		if (!this.main.contains(carte))
			throw new ExceptionHearthsone("Tu n'as pas cette carte dans ta main ! ");
		if(mana<carte.getMana())
			throw new ExceptionHearthsone("Tu n'as pas assez de mana");
		this.mana=this.mana - carte.getMana()
		this.main.remove(carte);
		this.cartes_posés.add(carte);
		//Test action avec cible
	}*/

	public final void perdreCarte(Carte carte) { //throws jeu.ExceptionHearthstone{
		if (!this.cartes_poses.contains(carte))
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Carte non posés sur le plateau");
		this.cartes_poses.remove(carte);
	}
	
	public final void utiliserCarte(Carte carte, Object cible) { //throws jeu.ExceptionHearthstone{
		if (!this.cartes_poses.contains(carte))
			System.out.println("erreur");
			//throw new ExceptionHearthsone("Carte non posés sur le plateau");
		//carte.ExecuterAction();
		if (carte.disparait() && this.cartes_poses.contains(carte))
			this. cartes_poses.remove(carte);
	}
		
	//public final void utiliserPouvoir(Object cible) { //throws jeu.ExceptionHearthstone{
		//if(this.heros.getPouvoir() ==null)
			//System.out.println("erreur");
			//throw new ExceptionHearthsone("Ton héros ne possède pas de pouvoir ");
		//this.heros.utiliserPouvoir(cible);
	
	
	public final Carte getCarteEnJeu(String nomCarte)
	{
		for(Carte c: this.cartes_poses) {
			
			if(c.getNom().contains(nomCarte))
			{
				return c;
			}
			
		}
		
		return null;
		
	}
	public final Carte getCarteEnMain(String nomCarte)
	{
		for(Carte c : this.main) {
			
			if(c.getNom().contains(nomCarte))
				return c;
		}
		
		return null;
		
	}
	
}
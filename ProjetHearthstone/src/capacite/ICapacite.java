package capacite ;
public abstract interface ICapacite{
	public abstract void executerAction(Object cible) ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetDebutTour() ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetDisparition(Object cible) ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetFinTour() ; //throws jeu.ExceptionHearthstone;
	public abstract void executerEffetMiseEnJeu(Object cible); //throws jeu.ExceptionHearthstone;
	public abstract String getDescription();
	public abstract String getNom();

}

package capacite;

import carte.Serviteur;

public class LachezChiens extends Invocation {

	
	public LachezChiens() {
		
		super("Invocation des chiens ", "Invoque autant de chiens que de serviteurs adverses" , new Serviteur("Chien" ,  0 , null , 1 ,1, new Charge()));
	}
}

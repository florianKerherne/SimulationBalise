package model;

import java.util.Observable;

public class Entite extends Observable{
	
	private Deplacement deplacement;
	
	public Entite() {
	}

	public Deplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}

}

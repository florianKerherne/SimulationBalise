package model;

import java.util.Observable;

public class Entite extends Observable{
	
	private Deplacement deplacement;
	private Position position;
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Entite() {
	}

	public Deplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}

}

package model;

import model.deplacement.Deplacement;

public abstract class Entite{
	
	private Deplacement deplacement;
	private Position position;
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	

	public Deplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}
	
	public Position executeDeplacement(){
		Position result = null;
		if(deplacement!=null && position!=null) {
			deplacement.Move(position);
		}
	     return result;
	}

	public abstract void updateSimulation();
}

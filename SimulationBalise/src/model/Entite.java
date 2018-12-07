package model;

import java.util.Observable;
import java.util.Observer;

public abstract class Entite extends Observable{
	
	private Deplacement deplacement;
	private Position position;
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
		setChanged();
		notifyObservers();
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
			setChanged();
			notifyObservers();
		}
	     return result;
	}
	
	public abstract void sendObserver(Observable o);
	
	public abstract void sendObservable(Observer o);

	public abstract void updateSimulation();
}

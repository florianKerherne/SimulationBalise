package model;

import java.util.Observable;
import java.util.Observer;

public class Sattelite extends Entite {

	public Sattelite(Position position) {
		setDeplacement(new DeplacementSattelite());
		setPosition(position);
	}

	@Override
	public void sendObserver(Observable o) {
		
	}

	@Override
	public void sendObservable(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void updateSimulation() {
		setPosition(new Position(getPosition().getX()+1,getPosition().getY()));
	}

}

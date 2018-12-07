package model;

import java.util.Observable;
import java.util.Observer;

public class Balise extends Entite implements Observer {

	public Balise(Deplacement deplacement,Position position) {
		setDeplacement(deplacement);
		setPosition(position);
	}
	
	public Balise(Deplacement deplacement) {
		this(deplacement,new Position(0,0));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void sendObserver(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void sendObservable(Observer o) {
		
	}

	@Override
	public void updateSimulation() {
		executeDeplacement();
	}

}

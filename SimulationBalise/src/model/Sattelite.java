package model;

import java.util.Observable;
import java.util.Observer;

public class Sattelite extends Entite {

	@Override
	public void sendObserver(Observable o) {
		
	}

	@Override
	public void sendObservable(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void update() {
		setPosition(new Position(getPosition().getX()+1,getPosition().getY()));
	}

}

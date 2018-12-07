package model;

import java.util.Observable;
import java.util.Observer;

public class Sattelite extends Entite {

	int largeurZone = 50;
	
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
	
	public boolean dansZoneReception(Position pos) {
		int min = (getPosition().getX()-largeurZone)%500;
		int max = (getPosition().getX()+largeurZone)%500;
		if(pos.getX()>min && pos.getX()<max) {
			return true;
		}
		return false;
	}
	
	public void transmitionMessage(String message) {
		System.out.println(message);
	}

}

package model;

import java.util.Observable;
import java.util.Observer;

import ressources.GetPropertyValues;

public class Sattelite extends Entite {

	static final int largeurZone = 10;
	final int BordDroit ;
	
	public Sattelite(Position position) {
		setDeplacement(new DeplacementSattelite());
		setPosition(position);
		BordDroit = GetPropertyValues.getValuePropertie("BordDroit");
		//System.out.println(BordDroit);
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
		executeDeplacement();
		//setPosition(new Position(getPosition().getX()+1,getPosition().getY()));
	}
	
	public boolean dansZoneReception(Position pos) {
		int min = (getPosition().getX()-largeurZone)%BordDroit;
		int max = (getPosition().getX()+largeurZone)%BordDroit;
		if(pos.getX()>min && pos.getX()<max) {
			return true;
		}
		return false;
	}
	
	public void transmitionMessage(String message) {
		System.out.println(message);
	}

}

package model;

import java.util.Observable;
import java.util.Observer;

public class Balise extends Entite implements Observer {

	boolean MessageTransmis = false;
	public Balise(Deplacement deplacement,Position position) {
		setDeplacement(deplacement);
		setPosition(position);
	}
	
	public Balise(Deplacement deplacement) {
		this(deplacement,new Position(0,0));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(getPosition().getY()>=0 && MessageTransmis==false) {
			Sattelite sattelite = (Sattelite)arg0;
			if(sattelite.dansZoneReception(getPosition())) {
				sattelite.transmitionMessage("coucou");
				MessageTransmis=true;
			}
		}
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
		if(getPosition().getY()<0) {
			executeDeplacement();
		} else {
			if(MessageTransmis) {
				executeDeplacement();
				MessageTransmis=false;				
			}
			
		}
	}

}

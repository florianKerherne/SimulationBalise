package gestionEvenement.evenement;

import gestionEvenement.ObserverSimulation;

public abstract class Evenement {

	Object source;
	
	public Evenement(Object source) {
		this.source = source;
	}
	
	public Object getSource() {
		return source;
	}
	
	public abstract void sendTo(ObserverSimulation o);

}

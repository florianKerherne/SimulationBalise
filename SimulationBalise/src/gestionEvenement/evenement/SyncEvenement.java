package gestionEvenement.evenement;

import gestionEvenement.ObserverSimulation;

public class SyncEvenement extends Evenement{

	public SyncEvenement(Object source) {
		super(source);
	}

	@Override
	public void sendTo(ObserverSimulation o) {
		o.receive(this);
	}

}

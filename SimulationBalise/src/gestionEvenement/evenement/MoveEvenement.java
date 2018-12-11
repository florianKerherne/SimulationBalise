package gestionEvenement.evenement;

import gestionEvenement.ObserverSimulation;

public class MoveEvenement extends Evenement{

	public MoveEvenement(Object source) {
		super(source);
	}

	@Override
	public void sendTo(ObserverSimulation o) {
		o.receive(this);
	}

}

package gestionEvenement;

import gestionEvenement.evenement.Evenement;

public interface ObserverSimulation {

	public void receiveFrom(Object o,Evenement e);
}

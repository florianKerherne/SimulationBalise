package gestionEvenement;

import gestionEvenement.evenement.Evenement;
import gestionEvenement.evenement.MoveEvenement;
import gestionEvenement.evenement.SyncEvenement;

public interface ObserverSimulation {

	void receive(MoveEvenement moveEvenement);

	void receive(SyncEvenement syncEvenement);

	//public void receive(Evenement e);
	
}

package gestionEvenement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gestionEvenement.evenement.Evenement;

public class Annonceur {
	
	Map<Class<?extends Evenement>, List<ObserverSimulation>> subscriptions;
	
	public void subscribes(Class<?extends Evenement> eventKind, ObserverSimulation o) {
		List<ObserverSimulation> listObserver = subscriptions.get(eventKind);
		if(listObserver == null) {
			listObserver = new ArrayList<ObserverSimulation>();
			subscriptions.put(eventKind, listObserver);
		}
		listObserver.add(o);
	}
	
	public void unsubscribes(Class<?extends Evenement> eventKind, ObserverSimulation o) {
		
		
	}
	
	public void announce(Evenement e, Object emetteur) {
		
		List<ObserverSimulation> listObserver = subscriptions.get(e.getClass());
		
		if(listObserver == null) return;
		Iterator<ObserverSimulation> ite = listObserver.iterator();
		while(ite.hasNext()) {
			ite.next().receiveFrom(emetteur, e);
		}
	}

}



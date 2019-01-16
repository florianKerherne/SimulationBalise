package gestionEvenement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gestionEvenement.evenement.Evenement;

public class Annonceur {
	
	Map<Class<?extends Evenement>, List<ObserverSimulation>> subscriptions;
	
	public Annonceur() {
		subscriptions = new HashMap<Class<? extends Evenement>, List<ObserverSimulation>>();
	}
	
	public void subscribes(Class<?extends Evenement> eventKind, ObserverSimulation o) {
		List<ObserverSimulation> listObserver = subscriptions.get(eventKind);
		if(listObserver == null) {
			listObserver = new ArrayList<ObserverSimulation>();
			subscriptions.put(eventKind, listObserver);
		}
		listObserver.add(o);
	}
	
	public void unsubscribes(Class<?extends Evenement> eventKind, ObserverSimulation o) {
		
		List<ObserverSimulation> listObserver = subscriptions.get(eventKind);
		if(listObserver==null)return;
		Iterator<ObserverSimulation> itor =  listObserver.iterator();
		while (itor.hasNext()) {
			ObserverSimulation current = itor.next();
			if (o == current) itor.remove();
		}
		if (listObserver.isEmpty()) {
			subscriptions.remove(eventKind);
		}
	}
	
	public void announce(Evenement e) {
		
		List<ObserverSimulation> listObserver = subscriptions.get(e.getClass());
		
		if(listObserver == null) return;
		for(ObserverSimulation obs:listObserver) {
			e.sendTo(obs);
		}
	}

}



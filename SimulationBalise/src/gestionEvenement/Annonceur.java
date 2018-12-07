package gestionEvenement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;

public class Annonceur {
	
	Map<Class<?extends Evenement>, List<Observer>> subscriptions;
	
	public void subscribes(Class<?extends Evenement> eventKind, Observer o) {
		List<Observer> listObserver = subscriptions.get(eventKind);
		if(listObserver == null) {
			listObserver = new ArrayList<Observer>();
			subscriptions.put(eventKind, listObserver);
		}
		listObserver.add(o);
	}
	
	public void announce(Evenement e, Object emetteur) {
		
		List<Observer> listObserver = subscriptions.get(e.getClass());
		
		if(listObserver == null) return;
		Iterator<Observer> ite = listObserver.iterator();
		while(ite.hasNext()) {
			//ite.next()getClass().receiveFrom(emetteur, e);
		}
	}

}



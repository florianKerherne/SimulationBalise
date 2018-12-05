package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model {

	private List<Entite> listEntites;
	
	public Model() {
		this.listEntites = new ArrayList<Entite>();
	}

	public List<Entite> getListEntites() {
		return listEntites;
	}

	public void addListEntites(Entite entite) {
		listEntites.add(entite);
	}
	
	public Entite createSattelite(int x,int y) {
		Sattelite satelite = new Sattelite();
		//satelite.addObserver(o);
		sendObservable(satelite);
		satelite.setPosition(new Position(x,y));
		listEntites.add(satelite);
		return satelite;
	}
	
	public Entite createBalise(int x,int y) {
		Balise balise = new Balise();
		sendObserver(balise);
		balise.setPosition(new Position(x,y));
		listEntites.add(balise);
		return balise;
	}
	
	public Entite createBalise(int x,int y,Deplacement dep) {
		Balise balise = new Balise();
		balise.setDeplacement(dep);
		sendObserver(balise);
		balise.setPosition(new Position(x,y));
		listEntites.add(balise);
		return balise;
	}
	
	private void sendObservable(Observable o) {
		for(Entite entite:listEntites) {
			entite.sendObserver(o);
		}
	}
	
	private void sendObserver(Observer o) {
		for(Entite entite:listEntites) {
			entite.sendObservable(o);
		}
	}
	
	public void nextTurn() {
		for(Entite entite:listEntites) {
			entite.nextTurn();
		}
	}
	
	
}

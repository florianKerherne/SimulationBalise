package model;

import java.util.ArrayList;
import java.util.List;

import model.deplacement.Deplacement;

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
		Sattelite satelite = new Sattelite(this,new Position(x,y));
		listEntites.add(satelite);
		return satelite;
	}
	
	public Entite createBalise(int x,int y,Deplacement dep) {
		Balise balise = new Balise(this,dep,new Position(x,y));
		listEntites.add(balise);
		return balise;
	}
	
	public void updateSimulation() {
		for(Entite entite:listEntites) {
			entite.updateSimulation();
		}
	}
	
	
}

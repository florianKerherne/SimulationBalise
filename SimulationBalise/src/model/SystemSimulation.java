package model;

import java.util.ArrayList;
import java.util.List;

import model.deplacement.Deplacement;
import model.deplacement.DeplacementVertical;
import ressources.GetPropertyValues;
import visiteur.Visitable;
import visiteur.Visiteur;

public class SystemSimulation implements Visitable {

	private List<Entite> listEntites;
	
	public SystemSimulation() {
		this.listEntites = new ArrayList<Entite>();
	}

	public List<Entite> getListEntites() {
		return listEntites;
	}

	public void addListEntites(Entite entite) {
		listEntites.add(entite);
	}
	
	public Entite createSattelite() {
		return createSattelite(0,GetPropertyValues.getValuePropertie("hauteurSatellite"));
	}
	
	public Entite createSattelite(int x,int y) {
		Sattelite satelite = new Sattelite(this,new Position(x,y));
		listEntites.add(satelite);
		return satelite;
	}
	
	public Entite createBalise() {
		return createBalise(0,0,new DeplacementVertical());
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

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}
	
	
}

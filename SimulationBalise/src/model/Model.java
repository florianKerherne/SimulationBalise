package model;

import java.util.ArrayList;
import java.util.List;

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
	
	
}

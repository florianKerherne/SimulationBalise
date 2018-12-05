package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model {

	private List<Observable> listEntites;
	
	public Model() {
		this.listEntites = new ArrayList<Observable>();
	}

	public List<Observable> getListEntites() {
		return listEntites;
	}

	public void addListEntites(Entite entite) {
		listEntites.add(entite);
	}
	
	
}

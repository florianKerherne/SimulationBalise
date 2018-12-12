package model;

import model.deplacement.DeplacementSattelite;
import ressources.GetPropertyValues;
import visiteur.Visiteur;

public class Sattelite extends Entite {

	static final int largeurZone = 25;
	final int BordDroit ;
	
	public Sattelite(SystemSimulation model,Position position) {
		super(model);
		setDeplacement(new DeplacementSattelite());
		setPosition(position);
		BordDroit = GetPropertyValues.getValuePropertie("BordDroit");
	}

	@Override
	public void updateSimulation() {
		executeDeplacement();
	}
	
	public boolean dansZoneReception(Position pos) {
		int min = (getPosition().getX()-largeurZone)%BordDroit;
		int max = (getPosition().getX()+largeurZone)%BordDroit;
		if(pos.getX()>min && pos.getX()<max) {
			return true;
		}
		return false;
	}
	
	public void transmitionMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}

}

package model;

import gestionEvenement.evenement.MoveEvenement;
import model.deplacement.DeplacementSattelite;
import ressources.GetPropertyValues;

public class Sattelite extends Entite {

	static final int largeurZone = 10;
	final int BordDroit ;
	
	public Sattelite(Position position) {
		setDeplacement(new DeplacementSattelite());
		setPosition(position);
		BordDroit = GetPropertyValues.getValuePropertie("BordDroit");
	}

	@Override
	public void updateSimulation() {
		executeDeplacement();
		//TODO Annoncer l evenement deplacer
		//.announce(new MoveEvenement(this), this);
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

}

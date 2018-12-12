package model.deplacement;

import model.Position;
import ressources.GetPropertyValues;

public class DeplacementSattelite implements Deplacement{

	final int pas;
	final int BordDroit;
	
	public DeplacementSattelite() {
		BordDroit = GetPropertyValues.getValuePropertie("BordDroit");
		pas = GetPropertyValues.getValuePropertie("pasSimulation");
	}
	
	@Override
	public Position Move(Position position) {
		if(position.getX() < BordDroit) {
			position.setX(position.getX()+pas);
		}else {
			position.setX(0);
		}
		return position;
	}
	
}

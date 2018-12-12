package model.deplacement;

import model.Position;
import ressources.GetPropertyValues;

public class DeplacementVertical implements Deplacement {
	
	final int descenteMax;
	final int pas;
	final int niveauMer;
	
	Boolean descente = true;
	
	public DeplacementVertical() {
		niveauMer = GetPropertyValues.getValuePropertie("niveauMer");
		pas = GetPropertyValues.getValuePropertie("pasSimulation");
		descenteMax = GetPropertyValues.getValuePropertie("fondOcean");
	}
	
	@Override
	public Position Move(Position p) {
		if(descente) {
			descendre(p);
		}else {
			monter(p);
		}
		return p;
	}
	
	public Position descendre(Position position) {
		position.setY(position.getY()-pas);
		if(position.getY() <= -descenteMax) {
			descente = false;
		}
		return position;
	}
	
	public Position monter(Position position) {
		position.setY(position.getY()+pas);
		if(position.getY() >= niveauMer) {
			descente = true;
		}
		return position;
	}

	

}

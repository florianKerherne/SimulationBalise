package model;

import ressources.GetPropertyValues;

public class DeplacementParabol implements Deplacement{

	static final int descenteMax = 200;
	static final int pas = 3;
	final int niveauMer;
	final int BordDroit;
	
	Boolean descente = true;
	
	public DeplacementParabol() {
		BordDroit = GetPropertyValues.getValuePropertie("BordDroit");
		niveauMer = GetPropertyValues.getValuePropertie("niveauMer");
	}
	
	@Override
	public Position Move(Position position) {
		float positionY = Math.abs(position.getY());
		float deplacementX = positionY/descenteMax + 1;
		deplacementX = deplacementX * pas;
		if(descente) {
			descendre(position);
		}else {
			monter(position);
		}
		if(position.getX() > BordDroit) {
			position.setX(0);
		}else {
			position.setX(position.getX() + Math.round(deplacementX));
		}
		return position;
	}
	
	public Position descendre(Position position) {
		float positionY = Math.abs(position.getY());
		float deplacementY = 1 - (positionY/descenteMax);
		deplacementY = deplacementY * pas + 1;
		position.setY(position.getY()-Math.round(deplacementY));
		if(position.getY() <= -descenteMax) {
			descente = false;
		}
		return position;
	}
	
	public Position monter(Position position) {
		float positionY = Math.abs(position.getY());
		float deplacementY = 1 - (positionY/descenteMax);
		deplacementY = deplacementY * pas + 1;
		position.setY(position.getY()+Math.round(deplacementY));
		if(position.getY() > niveauMer) {
			descente = true;
		}
		return position;
	}

}

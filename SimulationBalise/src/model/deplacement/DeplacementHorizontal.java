package model.deplacement;

import model.Position;
import ressources.GetPropertyValues;

public class DeplacementHorizontal implements Deplacement{

	final int descenteMax;
	final int pas;
	final int distanceAvancer;
	final int niveauMer;
	final int BordDroit;
	
	int etat = 1;
	//etat 1 = descendre;
	//etat 2 = avancer;
	//etat 3 = monter;
	
	public DeplacementHorizontal() {
		BordDroit = GetPropertyValues.getValuePropertie("BordDroit");
		niveauMer = GetPropertyValues.getValuePropertie("niveauMer");
		descenteMax = GetPropertyValues.getValuePropertie("fondOcean")-25;
		pas = GetPropertyValues.getValuePropertie("pasSimulation");
		distanceAvancer = GetPropertyValues.getValuePropertie("avancerHorizontal");
		
	}
	
	@Override
	public Position Move(Position p) {
		if(etat == 1) {
			descendre(p);
		}
		if(etat == 2) {
			avancer(p);
		}
		if(etat == 3) {
			monter(p);
		}
		return p;
	}
	
	public Position descendre(Position position) {
		position.setY(position.getY()-pas);
		if(position.getY() <= -descenteMax) {
			etat = 2;
		}
		return position;
	}
	
	public Position monter(Position position) {
		position.setY(position.getY()+pas);
		if(position.getY() >= niveauMer) {
			etat = 1;
		}
		return position;
	}
	
	public Position avancer(Position position) {
		if(position.getX() > BordDroit) {
			position.setX(0);
		}else {
			position.setX(position.getX()+pas);
		}
		if(position.getX()%distanceAvancer < pas) {
			etat = 3;
		}
		return position;
	}


}

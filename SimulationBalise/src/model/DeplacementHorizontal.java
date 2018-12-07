package model;

public class DeplacementHorizontal implements Deplacement{

	static final int descenteMax = 235;
	static final int pas = 3;
	static final int niveauMer = 0;
	static final int distanceAvancer = 300;
	
	int etat = 1;
	//etat 1 = descendre;
	//etat 2 = avancer;
	//etat 3 = monter;
	
	@Override
	public Position Move(Position p) {
		if(etat == 1) {
			decsendre(p);
		}
		if(etat == 2) {
			avancer(p);
		}
		if(etat == 3) {
			monter(p);
		}
		return p;
	}
	
	public Position decsendre(Position position) {
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
		position.setX(position.getX()+pas);
		if(position.getX()%distanceAvancer < pas) {
			etat = 3;
		}
		return position;
	}


}

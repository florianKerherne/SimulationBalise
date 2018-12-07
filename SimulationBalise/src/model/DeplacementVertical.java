package model;

public class DeplacementVertical implements Deplacement {
	
	static final int descenteMax = 100;
	static final int pas = 5;
	static final int niveauMer = 0;
	
	Boolean descente = true;
	
	@Override
	public Position Move(Position p) {
		if(descente) {
			decsendre(p);
		}else {
			monter(p);
		}
		return p;
	}
	
	public Position decsendre(Position position) {
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

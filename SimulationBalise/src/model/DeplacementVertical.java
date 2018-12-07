package model;

public class DeplacementVertical implements Deplacement {
	
	static final int descenteMax = 250;
	static final int pas = 3;
	static final int niveauMer = 0;
	
	Boolean descente = true;
	
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

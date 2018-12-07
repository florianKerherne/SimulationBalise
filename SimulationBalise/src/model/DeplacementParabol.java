package model;

public class DeplacementParabol implements Deplacement{

	static final int descenteMax = 200;
	static final int pas = 3;
	static final int niveauMer = 0;
	
	Boolean descente = true;
	
	@Override
	public Position Move(Position position) {
		int positionY = Math.abs(position.getY());
		int deplacementY = 1 - (positionY/descenteMax);
		deplacementY = deplacementY * pas + 1;
		int deplacementX = positionY/descenteMax;
		deplacementX = deplacementX * pas;
		if(position.getY() > descenteMax ) {
			descente = false;
		}else {
			descente = true;
		}
		if(descente) {
			position.setY(position.getY()-deplacementY);
		}else {
			position.setY(position.getY()+deplacementY);
		}
		position.setX(position.getX()+deplacementX);
		return position;
	}

}

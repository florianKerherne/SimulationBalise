package model;

public class DeplacementSattelite implements Deplacement{

	static final int pas = 3;
	static final int BordDroit = 600;
	
	@Override
	public Position Move(Position position) {
		if(position.getX() > BordDroit) {
			position.setX(position.getX()-pas);
		}else {
			position.setX(0);
		}
		return position;
	}
	
}

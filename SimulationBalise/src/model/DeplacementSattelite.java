package model;

public class DeplacementSattelite implements Deplacement{

	static final int pas = 5;
	static final int BordDroit = 500;
	
	@Override
	public Position Move(Position position) {
		if(position.getX() > BordDroit) {
			position.setX(position.getX()-pas);
		}
		return position;
	}
	
}

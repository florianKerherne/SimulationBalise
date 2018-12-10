package gestionEvenement.evenement;

public abstract class Evenement {

	Object source;
	
	public Evenement(Object source) {
		this.source = source;
	}
	
	public Object getSource() {
		return source;
	}

}

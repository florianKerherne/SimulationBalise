package gestionEvenement.evenement;

public abstract class Evenement {

	Object source;
	
	public void setSource(Object source) {
		this.source = source;
	}
	
	public Object getSource() {
		return source;
	}

}

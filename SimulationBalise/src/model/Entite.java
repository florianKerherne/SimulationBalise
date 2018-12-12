package model;

import gestionEvenement.Annonceur;
import gestionEvenement.evenement.MoveEvenement;
import model.deplacement.Deplacement;
import visiteur.Visitable;

public abstract class Entite implements Visitable{
	
	private Annonceur annonceur;
	protected SystemSimulation model;
	private Deplacement deplacement;
	private Position position;
	
	public Entite(SystemSimulation model) {
		this.model	= model;
		annonceur = new Annonceur();
	}
	
	public Annonceur getAnnonceur() {
		return annonceur;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	

	public Deplacement getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}
	
	public Position executeDeplacement(){
		Position result = null;
		if(deplacement!=null && position!=null) {
			deplacement.Move(position);
			annonceur.announce(new MoveEvenement(this));
		}
	     return result;
	}

	public abstract void updateSimulation();
}

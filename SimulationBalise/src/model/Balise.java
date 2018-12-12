package model;

import gestionEvenement.ObserverSimulation;
import gestionEvenement.evenement.MoveEvenement;
import gestionEvenement.evenement.SyncEvenement;
import model.deplacement.Deplacement;
import ressources.GetPropertyValues;
import visiteur.Visiteur;

public class Balise extends Entite implements ObserverSimulation {

	boolean etatTransmission=false;
	int DonneeMessage = 0;
	int niveauMer = GetPropertyValues.getValuePropertie("niveauMer");
	
	public Balise(SystemSimulation model,Deplacement deplacement,Position position) {
		super(model);
		setDeplacement(deplacement);
		setPosition(position);
	}
	
	public Balise(SystemSimulation model,Deplacement deplacement) {
		//garder la liste de tout les satellite
		this(model,deplacement,new Position(0,0));
	}
	
	public boolean getMessageTransmis() {
		return etatTransmission;
	}

	//a chaque frame
	@Override
	public void updateSimulation() {
		//si immerge
		if(getPosition().getY() < niveauMer) {
			executeDeplacement();
			DonneeMessage++;
			if(getPosition().getY()>= niveauMer) subscribes();
		} else {	//si a la surface
			//si j ai transmis mon message au satellite
			if(DonneeMessage <=0) {
				//plonger
				unsubscribes();
				executeDeplacement();
			}
		}
		etatTransmission=false;
	}

	@Override
	public void receive(MoveEvenement e) {
		int quantiteDonnees = GetPropertyValues.getValuePropertie("quantiteDonnees");
		if(getPosition().getY()>=niveauMer && DonneeMessage>0) {
			Sattelite sattelite = (Sattelite)e.getSource();
			if(sattelite.dansZoneReception(getPosition())) {
				sattelite.transmitionMessage("donnee "+DonneeMessage);
				DonneeMessage -= quantiteDonnees;
				etatTransmission=true;
			}
		}
	}
	
	private void subscribes() {
		for(Entite entite:model.getListEntites()) {
			if(entite instanceof Sattelite) {
				Sattelite satellite = (Sattelite)entite;
				satellite.getAnnonceur().subscribes(MoveEvenement.class, this);
			}
		}
	}
	
	private void unsubscribes() {
		for(Entite entite:model.getListEntites()) {
			if(entite instanceof Sattelite) {
				Sattelite satellite = (Sattelite)entite;
				satellite.getAnnonceur().unsubscribes(MoveEvenement.class, this);
			}
		}
	}

	@Override
	public void receive(SyncEvenement syncEvenement) {
		
	}

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}

}

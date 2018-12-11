package model;

import gestionEvenement.ObserverSimulation;
import gestionEvenement.evenement.MoveEvenement;
import gestionEvenement.evenement.SyncEvenement;
import model.deplacement.Deplacement;

public class Balise extends Entite implements ObserverSimulation {

	boolean MessageTransmis = true;
	public Balise(Model model,Deplacement deplacement,Position position) {
		super(model);
		setDeplacement(deplacement);
		setPosition(position);
	}
	
	public Balise(Model model,Deplacement deplacement) {
		//garder la liste de tout les satellite
		this(model,deplacement,new Position(0,0));
	}
	
	public boolean getMessageTransmis() {
		return MessageTransmis;
	}

	/*@Override
	public void update(Observable arg0, Object arg1) {
		if(getPosition().getY()>=0 && MessageTransmis==false) {
			Sattelite sattelite = (Sattelite)arg0;
			if(sattelite.dansZoneReception(getPosition())) {
				sattelite.transmitionMessage("coucou");
				MessageTransmis=true;
			}
		}
	}*/

	//a chaque frame
	@Override
	public void updateSimulation() {
		//si immerge
		if(getPosition().getY()<0) {
			executeDeplacement();
			if(getPosition().getY()>=0) subscribes();
		} else {	//si a la surface
			//si j ai transmis mon message au satellite
			if(MessageTransmis) {
				//plonger
				unsubscribes();
				executeDeplacement();
				MessageTransmis=false;				
			}
			
		}
	}

	@Override
	public void receive(MoveEvenement e) {
		//System.out.println("receive");
		//si e est un signal du satelitte
		if(getPosition().getY()>=0 && MessageTransmis==false) {
			Sattelite sattelite = (Sattelite)e.getSource();
			if(sattelite.dansZoneReception(getPosition())) {
				sattelite.transmitionMessage("coucou");
				MessageTransmis=true;
			}
		}
	}
	
	private void subscribes() {
		for(Entite entite:model.getListEntites()) {
			if(entite instanceof Sattelite) {
				Sattelite satellite = (Sattelite)entite;
				satellite.getAnnonceur().subscribes(MoveEvenement.class, this);
				//System.out.println("inscription");
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

}

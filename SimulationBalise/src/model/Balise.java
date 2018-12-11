package model;

import gestionEvenement.ObserverSimulation;
import gestionEvenement.evenement.Evenement;
import model.deplacement.Deplacement;

public class Balise extends Entite implements ObserverSimulation {

	boolean MessageTransmis = true;
	public Balise(Deplacement deplacement,Position position) {
		setDeplacement(deplacement);
		setPosition(position);
	}
	
	public Balise(Deplacement deplacement) {
		//garder la liste de tout les satellite
		this(deplacement,new Position(0,0));
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
		} else {	//si a la surface
			
			//si pas inscrit a la l annonceur
			//s inscrire a tout les annonceur de satellite
			
			//si j ai transmis mon message au satellite
			if(MessageTransmis) {
				//plonger
				executeDeplacement();
				MessageTransmis=false;				
			}
			
		}
	}

	@Override
	public void receive(Evenement e) {
		
		//si e est un signal du satelitte
		if(getPosition().getY()>=0 && MessageTransmis==false) {
			Sattelite sattelite = (Sattelite)e.getSource();
			if(sattelite.dansZoneReception(getPosition())) {
				sattelite.transmitionMessage("coucou");
				MessageTransmis=true;
			}
		}
		//TODO se desinscrire de la liste
	}

}

package vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Map;

import gestionEvenement.evenement.MoveEvenement;
import model.Entite;
import model.SystemSimulation;

public class Interpreteur implements KeyListener{

	SystemSimulation model;
	World jc;
	Map<String,Entite> tabVariable;
	
	public Interpreteur(SystemSimulation model,World jc){
		this.model	= model;
		this.jc	= jc;
		jc.getSaisie().addKeyListener(this);
	}
	
	public boolean interpret(String command) {
		String[] tabCommand = command.split(" ");
		if(tabCommand.length<1)return false;
		try {
		switch (tabCommand[1]) {
		case "new":
			commandNew(tabCommand);
			break;
		case "delete":
			commandDelete(tabCommand);
			break;
		case "move":
			commandMove(tabCommand);
			break;
		case "color":
			commandColor(tabCommand);
			break;
		case "speed":
			commandSpeed(tabCommand);
			break;
		case "image":
			commandImage(tabCommand);
			break;
		case "help":
			commandHelp(tabCommand);
			break;
		default:
			throw new  IOException("");
		}
		} catch (IOException e) {
			log(e.getMessage());
		}
		return true;
	}
	
	private void commandNew(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
		Entite entite;
		switch (command[2]) {
		case "balise":
			entite	= model.createBalise();
			break;
		case "satellite":
			entite	= model.createSattelite();
			
			break;
		default:
			throw new  IOException("");
		}
		//garder en memoire la variable
		tabVariable.put(command[3], entite);
		//la vue ecoute l'entite
		entite.getAnnonceur().subscribes(MoveEvenement.class, jc);
	}
	
	private void commandDelete(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
	}
	
	private void commandMove(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
	}
	
	private void commandColor(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
	}
	
	private void commandSpeed(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
	}
	
	private void commandImage(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
	}
	
	private void commandHelp(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("");
		}
	}


	private void log(String error) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		jc.getLog().setText(jc.getSaisie().getText());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

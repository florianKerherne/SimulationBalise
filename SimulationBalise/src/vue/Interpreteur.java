package vue;

import java.io.IOException;
import java.util.Map;

import model.Entite;
import model.SystemSimulation;
import model.deplacement.DeplacementVertical;

public class Interpreteur {

	SystemSimulation model;
	World jc;
	Map<String,Entite> tabVariable;
	
	Interpreteur(SystemSimulation model,World jc){
		this.model	= model;
		this.jc	= jc;
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
		switch (command[2]) {
		case "balise":
			model.createBalise();
			break;
		case "satellite":
			model.createSattelite();
			break;
		default:
			throw new  IOException("");
		}
		
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
}

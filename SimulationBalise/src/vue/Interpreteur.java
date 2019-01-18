package vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import gestionEvenement.evenement.MoveEvenement;
import gestionEvenement.evenement.SyncEvenement;
import model.Entite;
import model.SystemSimulation;
import model.deplacement.DeplacementHorizontal;
import model.deplacement.DeplacementParabol;
import model.deplacement.DeplacementVertical;
import ressources.GetPropertyValues;

public class Interpreteur implements KeyListener{

	SystemSimulation model;
	World jc;
	Map<String,Entite> tabVariable;
	String command = "";
	boolean pause = false;
	
	public Interpreteur(SystemSimulation model,World jc){
		tabVariable = new HashMap<String, Entite>();
		this.model	= model;
		this.jc	= jc;
		jc.getSaisie().addKeyListener(this);
	}
	
	public void start() {
		while (true) {
			//------- command
			interpret();
			//------- action
			if(!pause) {
				model.updateSimulation();
			}
			
			try {
				Thread.sleep(GetPropertyValues.getValuePropertie("vitesseSimulation"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public boolean interpret() {
		if(!command.isEmpty()) {
			boolean result = MultiInterpret(command);
			command="";
			return result;
		}
		return false;
	}
	
	public boolean MultiInterpret(String multiCommand) {
		multiCommand = multiCommand.replace("\n","");
		String[] tabCommand = multiCommand.split(";");
		for(String command : tabCommand) {
			if(!interpret(command)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean interpret(String command) {
		command = command.replace("\n","");
		String[] tabCommand = command.split(" ");
		if(tabCommand.length<1)return false;
		try {
		switch (tabCommand[0]) {
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
		case "start":
			commandStart(tabCommand);
			break;
		case "stop":
			commandStop(tabCommand);
			break;
		case "init":
			commandInit(tabCommand);
			break;
		default:
			throw new  IOException("Command "+tabCommand[0]+"invalide");
		}
		} catch (IOException e) {
			log(e.getMessage());
		}
		jc.repaint();
		return true;
	}
	
	private void commandNew(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("ERROR : arguments invalides : new [balise|baliseHorizontale|baliseVerticale|baliseParabole|satellite] {nom}");
		}
		if(tabVariable.get(command[2])!=null) {
			throw new  IOException("ERROR : argument nom invalide : Ce nom est déjà utilisé");
		}
		Entite entite;
		switch (command[1]) {
		case "baliseHorizontale":
			entite	= model.createBalise(100, 0,new DeplacementHorizontal());
			log("Balise Horizontale "+command[2]+" créée");
			break;
		case "baliseVerticale": case "balise":
			entite	= model.createBalise(100, 0,new DeplacementVertical());
			log("Balise Verticale "+command[2]+" créée");
			break;
		case "baliseParabole":
			entite	= model.createBalise(100, 0,new DeplacementParabol());
			log("Balise Parabole "+command[2]+" créée");
			break;
		case "satellite":
			int hauteur = GetPropertyValues.getValuePropertie("hauteurSatellite");
			entite	= model.createSattelite(50,hauteur);
			log("Satelitte "+command[2]+" cree");
			break;
		default:
			throw new  IOException("ERROR : type inconnu");
		}
		//garder en memoire la variable
		tabVariable.put(command[2], entite);
		//la vue ecoute l'entite
		entite.getAnnonceur().subscribes(MoveEvenement.class, jc);
		entite.getAnnonceur().subscribes(SyncEvenement.class, jc);
	}
	
	private void commandDelete(String[] command) throws IOException {
		if(command.length!=2) {
			throw new  IOException("ERROR : arguments invalides : delete {nom}");
		}
		Entite entite = tabVariable.get(command[1]);
		if(entite == null) {
			throw new  IOException("ERROR : Nom de l'entité inconnu");
		}
		model.getListEntites().remove(entite);
		//TODO supprimer les balise des gestionnaire d'evenement des satellite pour evité les fuite memoire
		tabVariable.remove(command[1]);
	}
	
	private void commandMove(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("ERROR :");
		}
	}
	
	private void commandColor(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("ERROR :");
		}
	}
	
	private void commandSpeed(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("ERROR :");
		}
	}
	
	private void commandImage(String[] command) throws IOException {
		if(command.length!=3) {
			throw new  IOException("ERROR :");
		}
	}
	
	private void commandStart(String[] command) throws IOException {
		if(command.length!=1) {
			throw new  IOException("ERROR : start");
		}
		pause = false;
		log("Simulation démarré");
	}
	
	private void commandStop(String[] command) throws IOException {
		if(command.length!=1) {
			throw new  IOException("ERROR : stop");
		}
		pause = true;
		log("Simulation arreté");
	}
	
	private void commandInit(String[] command) throws IOException {
		if(command.length!=1) {
			throw new  IOException("ERROR : init");
		}
		model.getListEntites().clear();
		log("Simulation réinitialisé");
	}
	
	private void commandHelp(String[] command) throws IOException {
		if(command.length!=1) {
			throw new  IOException("ERROR : help");
		}
		log("command : [new|delete|start|stop|init]");
	}


	private void log(String error) {
		jc.getLog().setText(jc.getLog().getText()+"\n"+error);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			command = jc.getSaisie().getText();
			//interpret(jc.getSaisie().getText());
			jc.getSaisie().setText("");
		}
		
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

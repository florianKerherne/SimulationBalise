package visiteur;

import model.Balise;
import model.SystemSimulation;
import model.Sattelite;

public abstract class Visiteur {

	public abstract void visit(SystemSimulation model);

	public abstract void visit(Balise balise);

	public abstract void visit(Sattelite sattelite);

}

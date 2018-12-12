package visiteur;

import model.Balise;
import model.Model;
import model.Sattelite;

public abstract class Visiteur {

	public abstract void visit(Model model);

	public abstract void visit(Balise balise);

	public abstract void visit(Sattelite sattelite);

}

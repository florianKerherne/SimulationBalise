
package test;

import java.awt.Color;
import java.awt.Dimension;
import model.DeplacementHorizontal;
import model.DeplacementParabol;
import model.DeplacementVertical;
import model.Entite;
import model.Model;
import ressources.GetPropertyValues;
import vue.World;


public class Example1 {

	public static void main(String[] args) {
		Model model = new Model();
		model.createBalise(150,0,new DeplacementVertical());
		model.createBalise(50,0,new DeplacementHorizontal());
		model.createBalise(00,0,new DeplacementParabol());
		model.createSattelite(50,50);
		model.createSattelite(200,50);
		lance(model);
	}
	
	private static void lance(Model model) {
		World jc = new World("Un essai de Morphs");
		for(Entite entite:model.getListEntites()) {
			entite.addObserver(jc);
		}
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(GetPropertyValues.getValuePropertie("BordDroit"), 600));

		jc.setModel(model);
		jc.open();
		while (true) {
			//jc.repaint();
			//------- action
			model.updateSimulation();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


package test;

import java.awt.Color;
import java.awt.Dimension;

import model.Entite;
import model.SystemSimulation;
import model.deplacement.DeplacementHorizontal;
import model.deplacement.DeplacementParabol;
import model.deplacement.DeplacementVertical;
import ressources.GetPropertyValues;
import vue.World;


public class Example1 {

	public static void main(String[] args) {
		SystemSimulation model = new SystemSimulation();
		model.createBalise(150,0,new DeplacementVertical());
		model.createBalise(50,0,new DeplacementHorizontal());
		model.createBalise(00,0,new DeplacementParabol());
		model.createSattelite(50,50);
		model.createSattelite(600,50);
		lance(model);
	}
	
	private static void lance(SystemSimulation model) {
		World jc = new World("Simulateur de balise");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(GetPropertyValues.getValuePropertie("BordDroit"), 900));

		jc.setModel(model);
		jc.open();
		while (true) {
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

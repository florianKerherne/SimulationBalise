
package test;

import java.awt.Color;
import java.awt.Dimension;

import model.Entite;
import model.SystemSimulation;
import model.deplacement.DeplacementHorizontal;
import model.deplacement.DeplacementParabol;
import model.deplacement.DeplacementVertical;
import ressources.GetPropertyValues;
import vue.Interpreteur;
import vue.World;


public class Example1 {

	public static SystemSimulation model;
	public static void main(String[] args) {
		int hauteur = GetPropertyValues.getValuePropertie("hauteurSatellite");
		model = new SystemSimulation();
		model.createBalise(150,0,new DeplacementVertical());
		model.createBalise(50,0,new DeplacementHorizontal());
		model.createBalise(00,0,new DeplacementParabol());
		model.createSattelite(50,hauteur);
		model.createSattelite(600,hauteur);
		lance(model);
	}
	
	private static void lance(SystemSimulation model) {
		World jc = new World("Simulateur de balise");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(GetPropertyValues.getValuePropertie("BordDroit"), 900));

		jc.setModel(model);
		jc.open();
		Interpreteur inter = new Interpreteur(model,jc); 
		while (true) {
			//------- action
			model.updateSimulation();
			try {
				Thread.sleep(GetPropertyValues.getValuePropertie("vitesseSimulation"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

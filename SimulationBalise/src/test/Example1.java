
package test;

import java.awt.Color;
import java.awt.Dimension;
import model.Balise;
import model.Entite;
import model.Model;
import model.Position;
import model.Sattelite;
import vue.World;


public class Example1 {

	public static void main(String[] args) {
		Model model = new Model();
		model.createBalise(50,50);
		model.createSattelite(50,10);
		model.createSattelite(20,20);
		lance(model);
	}
	
	/*private static Entite createSattelite(int x,int y) {
		Sattelite satelite = new Sattelite();
		satelite.setPosition(new Position(x,y));
		return satelite;
	}
	
	private static Entite createBalise(int x,int y) {
		Balise satelite = new Balise();
		satelite.setPosition(new Position(x,y));
		return satelite;
	}*/
	
	private static void lance(Model model) {
		World jc = new World("Un essai de Morphs");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));

		jc.setModel(model);
		jc.open();
		while (true) {
			//jc.repaint();
			//------- action
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

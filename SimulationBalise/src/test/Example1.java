
package test;

import java.awt.Color;
import java.awt.Dimension;
import model.Balise;
import model.Model;
import model.Sattelite;
import vue.World;


public class Example1 {

	public static void main(String[] args) {
		Model model = new Model();
		model.addListEntites(new Sattelite());
		model.addListEntites(new Balise());
		model.addListEntites(new Balise());
		lance(model);
	}
	
	private static void lance(Model model) {
		World jc = new World("Un essai de Morphs");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));

		jc.setModel(model);
		jc.open();
		while (true) {
			jc.repaint();
			//------- action
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

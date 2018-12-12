package visiteur;

import java.awt.Color;
import java.awt.Graphics;

import model.Balise;
import model.Entite;
import model.SystemSimulation;
import model.Sattelite;

public class VisiteurDraw extends Visiteur {

	Graphics graphique;
	public VisiteurDraw(Graphics graphique) {
		this.graphique	= graphique;
		drawDecors();
	}
	@Override
	public void visit(SystemSimulation model) {
		for(Entite entity: model.getListEntites()) {
			entity.accept(this);
		}
	}

	@Override
	public void visit(Balise balise) {
		Color c = graphique.getColor();
		if(balise.getPosition().getY() <= 0) {
			graphique.setColor(Color.BLUE);
		}
		if(balise.getPosition().getY() >= 0) {
			graphique.setColor(Color.ORANGE);
		}
		if(balise.getMessageTransmis()) {
			graphique.setColor(Color.GREEN);
		}
		
		int positionY = Math.abs(balise.getPosition().getY() -100) ;
		graphique.fillOval(balise.getPosition().getX(),positionY,10,10);
		//(bounds.x,bounds.y,bounds.height,bounds.width);
		graphique.setColor(c);
	}

	@Override
	public void visit(Sattelite sattelite) {
		Color c = graphique.getColor();
		graphique.setColor(Color.RED);
		int positionY = Math.abs(sattelite.getPosition().getY() -100) ;
		graphique.fillOval(sattelite.getPosition().getX(),positionY,10,10);//(bounds.x,bounds.y,bounds.height,bounds.width);
		graphique.setColor(c);
	}
	
	public void drawDecors() {
		graphique.fillRect(0, 100, 1000, 1);
	}

}

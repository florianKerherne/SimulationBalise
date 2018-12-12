package visiteur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import model.Balise;
import model.Entite;
import model.SystemSimulation;
import ressources.GetPropertyValues;
import model.Sattelite;

public class VisiteurDraw extends Visiteur {

	Graphics graphique;
	String PathImageSatellite;
	String PathImageBalise;
	int niveauMer = GetPropertyValues.getValuePropertie("niveauMer");
	
	public VisiteurDraw(Graphics graphique) {
		this.graphique	= graphique;
		this.PathImageSatellite = GetPropertyValues.getValuePropertieString("PathImageSatellite");
		this.PathImageBalise = GetPropertyValues.getValuePropertieString("PathImageBalise");
		drawDecors();
	}
	
	public void setPathImageSatellite(String pathImageSatellite) {
		PathImageSatellite = pathImageSatellite;
	}
	
	public void setPathImageBalise(String pathImageBalise) {
		PathImageBalise = pathImageBalise;
	}
	
	@Override
	public void visit(SystemSimulation model) {
		for(Entite entity: model.getListEntites()) {
			entity.accept(this);
		}
	}

	@Override
	public void visit(Balise balise) {
		Image image = Toolkit.getDefaultToolkit().getImage(PathImageBalise);
		
		if(balise.getPosition().getY() <= niveauMer) {
			graphique.setColor(Color.BLUE);
		}
		if(balise.getPosition().getY() >= niveauMer) {
			graphique.setColor(Color.ORANGE);
		}
		if(balise.getMessageTransmis()) {
			graphique.setColor(Color.GREEN);
		}
		
		int positionY = Math.abs(balise.getPosition().getY() -300) ;
		//graphique.fillOval(balise.getPosition().getX(),positionY,10,10);
		graphique.drawImage(image, balise.getPosition().getX(),positionY,null);
		graphique.drawRect(balise.getPosition().getX(), positionY, 128, 128);
	}

	@Override
	public void visit(Sattelite sattelite) {
		Image image = Toolkit.getDefaultToolkit().getImage(PathImageSatellite);
		
		graphique.setColor(Color.RED);
		int positionY = Math.abs(sattelite.getPosition().getY() -100) ;
		//graphique.fillOval(sattelite.getPosition().getX(),positionY,10,10);
		graphique.drawImage(image, sattelite.getPosition().getX(),positionY,null);
	}
	
	public void drawDecors() {
		graphique.fillRect(0, niveauMer+300, 2000, 1);
	}

}

package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Balise;
import model.Model;
import model.Sattelite;

public class World extends JPanel implements KeyListener,Observer {
	private static final long serialVersionUID = 1L;

	Model model;
	private KeyListener keyListener;

	String name = "";

	public World(String name) {
		this.name = name;
		this.addKeyListener(this);
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void open() {
		JFrame frame = new JFrame(name);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(wa);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		requestFocus();
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		drawDecors(g);
		for(Observable entity: model.getListEntites()) {
			draw(g,entity);
		}
	}
	
	private void draw(Graphics g, Observable entity) {
		if(entity instanceof Sattelite)draw(g,(Sattelite)entity);
		if(entity instanceof Balise)draw(g,(Balise)entity);
	}

	public void drawDecors(Graphics g) {
		g.fillRect(0, 100, 1000, 1);
	}
	public void draw(Graphics g,Sattelite sattelite) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		int positionY = Math.abs(sattelite.getPosition().getY() -100) ;
		g.fillOval(sattelite.getPosition().getX(),positionY,10,10);//(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
	}
	
	public void draw(Graphics g,Balise balise) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		int positionY = Math.abs(balise.getPosition().getY() -100) ;
		g.fillOval(balise.getPosition().getX(),positionY,10,10);
		//(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
	}

	public void setKeyListener(KeyListener k) {
		keyListener = k;
	}

	public void clear() {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (keyListener != null) {
			keyListener.keyTyped(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (keyListener != null) {
			keyListener.keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (keyListener != null) {
			keyListener.keyReleased(e);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
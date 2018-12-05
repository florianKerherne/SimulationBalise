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

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Balise;
import model.Entite;
import model.Model;
import model.Sattelite;

public class World extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;

	//private List<Entite> drawables = Collections.synchronizedList(new LinkedList<Entite>());
	Model model;
	private KeyListener keyListener;

	String name = "";

	public World(String name) {
		this.name = name;
		this.addKeyListener(this);
	}

	/*public List<Entite> contents() {
		return drawables;
	}*/
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

/*	public void add(Entite d) {
		drawables.add(d);
		//d.setWorld(this);
		repaint();
	}*/

	/*public void remove(Entite d) {
		//d.setWorld(null);
		drawables.remove(d);
		repaint();
	}*/

	public void paint(Graphics g) {
		super.paint(g);
		//synchronized (drawables) {
			//for (Iterator<Entite> iter = drawables.iterator(); iter.hasNext();) {
		//for (Iterator<Entite> iter = model.getListEntites().iterator(); iter.hasNext();) {
			for(Observable entity: model.getListEntites()) {
				//iter.next();//.draw(g);
				draw(g,entity);//iter.next());
			}
		//}
	}
	
	private void draw(Graphics g, Observable entity) {
		if(entity instanceof Sattelite)draw(g,(Sattelite)entity);
		if(entity instanceof Balise)draw(g,(Balise)entity);
	}

	public void draw(Graphics g,Sattelite sattelite) {
		Color c = g.getColor();
		g.setColor(new Color(155));
		g.fillOval(0,0,10,10);//(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
		//super.draw(g);
	}
	
	public void draw(Graphics g,Balise balise) {
		Color c = g.getColor();
		g.setColor(new Color(255));
		g.fillOval(20,20,10,10);//(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
		//super.draw(g);
	}

	public void setKeyListener(KeyListener k) {
		keyListener = k;
	}

	public void clear() {
		/*for (Iterator<Entite> iter = drawables.iterator(); iter.hasNext();) {
			iter.next();//.setWorld(null);
		}
		drawables.clear();*/
		repaint();
	}

	/*public List<Entite> find(Point p) {
		List<Entite> l = new ArrayList<Entite>();
		for (Iterator<Entite> iter = drawables.iterator(); iter.hasNext();) {
			Entite element = iter.next();
			if (element.getBounds().contains(p)) {
				l.add(element);
			}
		}
		return l;
	}*/

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

}
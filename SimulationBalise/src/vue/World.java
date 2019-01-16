package vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gestionEvenement.ObserverSimulation;
import gestionEvenement.evenement.MoveEvenement;
import gestionEvenement.evenement.SyncEvenement;
import model.Entite;
import model.SystemSimulation;
import visiteur.VisiteurDraw;

public class World extends JPanel implements KeyListener,ObserverSimulation {
	private static final long serialVersionUID = 1L;

	
	SystemSimulation model;
	private KeyListener keyListener;

	JTextArea Saisie;
	JTextArea log;
	String name = "";

	public World(String name) {
		this.name = name;
		this.addKeyListener(this);
	}

	public void setModel(SystemSimulation model) {
		this.model = model;
	}

	public void open() {//principale
		JFrame frame = new JFrame(name);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(wa);
		
		JPanel Fsimulation = new JPanel();
	    JPanel Flog = new JPanel();
	    JPanel Fsaisie = new JPanel();
	    frame.getContentPane().add(Fsimulation, "North");
	    frame.getContentPane().add(Flog, "Center");
	    frame.getContentPane().add(Fsaisie, "South");
	    
	    Fsimulation.add(this);
		
	    log = new JTextArea("HW");
	    log.setLineWrap(true);
	    log.setEditable(false);
	    log.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth(),(int) log.getPreferredSize().getHeight()*3));
	    Flog.add(new JScrollPane(log));
	    
	    
	    Saisie = new JTextArea("Txt");
	    Saisie.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth(),(int) Saisie.getPreferredSize().getHeight()));
	    new Interpreteur(model,this); 
	    Fsaisie.add(new JScrollPane(Saisie));
		frame.pack();
		frame.setVisible(true);
		
		requestFocus();
		
		//ecoute des entite
		for(Entite entite:model.getListEntites()) {
			entite.getAnnonceur().subscribes(MoveEvenement.class, this);
		}
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		VisiteurDraw visiteur = new VisiteurDraw(g);
		model.accept(visiteur);
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
	public void receive(MoveEvenement moveEvenement) {
		repaint();
	}

	@Override
	public void receive(SyncEvenement syncEvenement) {
		repaint();
	}

	public JTextArea getSaisie() {
		return Saisie;
	}

	public JTextArea getLog() {
		return log;
	}

	
}
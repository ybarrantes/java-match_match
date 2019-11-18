package app.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import app.AppMusic;
import app.Assets;
import graphics.TransformImage;

public class AppFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 600;
	private AppMusic mainSound;
	
	public AppMusic getMainMusic() {
		return mainSound;
	}

	public AppFrame() {
		super();

		setTitle("Match Match");
		setResizable(false);
		setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setLayout(null);
		//setShape(new RoundRectangle2D.Double(0, 0, WIDTH, HEIGHT, 20, 20));
		//pack();
		

		init();
		
		PanelMenu panelPrincipal = new PanelMenu(this);
		add(panelPrincipal);

		setVisible(true);
	}
	
	private void init() {
		mainSound = new AppMusic(Assets.getMusicMainBackgound());
		mainSound.changeVolumen(-7.5f);
		mainSound.loop();
	}
	
	private void repaintComponents() {
		for(Component c : this.getContentPane().getComponents()) {
			c.repaint();
		}
	}
	
	private BufferedImage background = null;
	public void paint(Graphics g) {
		//super.paint(g);
		if(background == null) {
			System.out.println("background on");
			background = TransformImage.scale(Assets.getImageMainBackground(), new Dimension(WIDTH, HEIGHT));
		}
		
		System.out.println("background off");
		
		g.drawImage(background, 0, 0, null);
		g.dispose();
		
		repaintComponents();
	}

}

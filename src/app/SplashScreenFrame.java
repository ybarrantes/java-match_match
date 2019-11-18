package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import game.GameState;
import graphics.TransformImage;

public class SplashScreenFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 520, HEIGHT = 520;

	public SplashScreenFrame() {
		GameState.init();
		
		setTitle("Match Match");
		setResizable(false);
		setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(TransformImage.scale(Assets.getImageSplashScreenBackground(), new Dimension(WIDTH, HEIGHT)), 0, 0, null);		
		g.dispose();
	}
}

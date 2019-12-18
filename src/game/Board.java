package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import enums.EGameSize;

public class Board extends JFrame {
	
	public static final int WIDTH = 760, HEIGHT = 720;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EGameSize gameSize = EGameSize._4X4;
	public EGameSize getGameSize() {
		return gameSize;
	}

	public Board() {
		super();

		setTitle("Match Match");
		setResizable(false);
		//setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		//setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		//setShape(new RoundRectangle2D.Double(0, 0, WIDTH, HEIGHT, 20, 20));
		//pack();
		
		init();
		

		setVisible(true);
	}
	
	private void init() {
		// Define the panel to hold the buttons 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        int cantidad = 16;
		
		Card[] cards = new Card[cantidad];
		
		for(int i = 0; i < cantidad; i++) {
			System.out.println(i);
			cards[i] = new Card();
			panel.add(cards[i]);
		}
		
		this.add(panel);
	}

}

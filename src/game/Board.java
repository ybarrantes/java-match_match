package game;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.Assets;
import enums.ECardStatus;
import enums.EGameSize;
import listeners.ClickListener;

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
	
	private int index_1 = -1;
	private int index_2 = -1;
	
	private  Card[] cards;
	private int[] tags;
	

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
		

        cards = new Card[cantidad];
		tags = new int[cantidad];
		
		for(int i = 0; i < cantidad / 2; i++) {
			tags[i] = i;
			int i2 = (cantidad / 2) + i;
			tags[i2] = i;
		}
		
		Random rnd = ThreadLocalRandom.current();
	    for (int i = tags.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = tags[index];
	      tags[index] = tags[i];
	      tags[i] = a;
	    }
		
		for(int i = 0; i < cantidad; i++) {
			System.out.println(i);
			Card card = new Card();
			
			card.setTag("card_" + tags[i]);
			card.setIndex(i);
			card.setImageMatch(Assets.getImageGameNumbers()[tags[i]]);
			//card.setText(card.getTag());
			card.setClickListener(new ClickListener() {

				@Override
				public void onClick(MouseEvent e, Object sender) {
					Card myCard = (Card)sender;
					System.out.println(card.getTag());
					if(index_1 == -1) {
						index_1 = myCard.getIndex();
						myCard.setStatus(ECardStatus.Visible);
						System.out.println("Marcando " + myCard.getTag() + " - " + index_1);
					} else if(index_2 == -1) {
						index_2 = myCard.getIndex();
						myCard.setStatus(ECardStatus.Visible);
						System.out.println("Marcando " + myCard.getTag() + " - " + index_2);
					}
					
					if(index_1 != -1 && index_2 != -1) {
						new java.util.Timer().schedule( 
						        new java.util.TimerTask() {
						            @Override
						            public void run() {
						            	System.out.println("1: " + index_1 + " | 2: " + index_2);
										if(cards[index_1].getTag().equals(cards[index_2].getTag())) {
											cards[index_1].setStatus(ECardStatus.Match);
											cards[index_2].setStatus(ECardStatus.Match);
											System.out.println("Match " + cards[index_2].getTag());
										} else {
											cards[index_1].setStatus(ECardStatus.Hidden);
											cards[index_2].setStatus(ECardStatus.Hidden);
											System.out.println("No Match " + cards[index_2].getTag());
										}
										
										index_1 = -1;
										index_2 = -1;
						            }
						        }, 
						        800 
						);
						
					}
				}
				
			});
			
			cards[i] = card;
			panel.add(card);
		}
		
		this.add(panel);
	}

}

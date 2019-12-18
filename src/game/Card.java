package game;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import app.Assets;
import graphics.TransformImage;

public class Card extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Card() {
		super();
		
		setIcon(new ImageIcon(TransformImage.scale(Assets.getImageCard(), new Dimension(110, 150))));
		setVisible(true);
	}

}

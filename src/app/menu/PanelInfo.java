package app.menu;

import java.awt.Color;

import javax.swing.JPanel;

import app.Assets;
import enums.EButtonState;
import ui.ImageButton;

public class PanelInfo extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelInfo(AppFrame parent) {
		super();
		//setBackground(new Color(0, 0, 0, 0));
		setBackground(new Color(255, 0, 0, 255));
		setBounds(0, 0, 600, 400);
		setLayout(null);
		setDoubleBuffered(true);
		
		ImageButton buttonMenuOptionNumbers = new ImageButton(parent, Assets.getImageButtonMenuOptionNumbers());
		add(buttonMenuOptionNumbers);
		buttonMenuOptionNumbers.setLayout(null);
		buttonMenuOptionNumbers.setLocation(0, 0);
	}

}

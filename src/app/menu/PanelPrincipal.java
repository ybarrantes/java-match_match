package app.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import app.Assets;
import enums.EButtonState;
import enums.EButtonType;
import enums.EViewMenuPrincipal;
import game.GameState;
import listeners.ClickListener;
import ui.ImageButton;

public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String tagButtonControl = "buttonControl";
	private final String tagButtonGame = "buttonGame";
	private EViewMenuPrincipal viewMenuPrincipal = EViewMenuPrincipal.Menu;
	
	// botones de control
	private ImageButton buttonSound, buttonMusic, buttonInfo, buttonClose, buttonBack;
	// botones de juego
	private ImageButton buttonMenuOptionNumbers;

	public PanelPrincipal(AppFrame parent) {
		super();
		
		setBackground(new Color(0, 0, 0, 0));
		setBounds(0, 0, AppFrame.WIDTH, AppFrame.HEIGHT);
		setLayout(null);
		setDoubleBuffered(true);
		
		buttonSound = new ImageButton(parent, Assets.getImageButtonSoundOn(), Assets.getImageButtonSoundOff());
		buttonSound.setState(EButtonState.ON);
		add(buttonSound);
		buttonSound.setLayout(null);
		buttonSound.setLocation(20, 350);
		buttonSound.setTag(tagButtonControl);
		buttonSound.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				if(buttonSound.getType() == EButtonType.Check) {
					if(buttonSound.getState() == EButtonState.ON) GameState.mainSound = true;
					else if(buttonSound.getState() == EButtonState.OFF) GameState.mainSound = false;
				}
			}
			
		});
		
		buttonMusic = new ImageButton(parent, Assets.getImageButtonMusicOn(), Assets.getImageButtonMusicOff());
		buttonMusic.setState(EButtonState.ON);
		add(buttonMusic);
		buttonMusic.setLayout(null);
		buttonMusic.setLocation(40, 285);
		buttonMusic.setTag(tagButtonControl);
		buttonMusic.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				if(buttonMusic.getType() == EButtonType.Check) {
					if(buttonMusic.getState() == EButtonState.ON) {
						GameState.mainMusic = true;
						parent.getMainMusic().loop();
					} else if(buttonMusic.getState() == EButtonState.OFF) {
						GameState.mainMusic = false;
						parent.getMainMusic().pause();
					}
				}
			}
			
		});
		
		
		buttonInfo = new ImageButton(parent, Assets.getImageButtonInfo());
		add(buttonInfo);
		buttonInfo.setLayout(null);
		buttonInfo.setLocation(parent.getWidth() - buttonInfo.getWidth() - 20, 350);
		buttonInfo.setTag(tagButtonControl);
		buttonInfo.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				viewMenuPrincipal(EViewMenuPrincipal.Info);
			}
			
		});
		
		buttonBack = new ImageButton(parent, Assets.getImageButtonBack());
		add(buttonBack);
		buttonBack.setLayout(null);
		buttonBack.setLocation(parent.getWidth() - buttonBack.getWidth() - 20, 350);
		buttonBack.setTag(tagButtonControl);
		buttonBack.setVisible(false);
		buttonBack.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				viewMenuPrincipal(EViewMenuPrincipal.Menu);
			}
			
		});
		
		
		buttonClose = new ImageButton(parent, Assets.getImageButtonClose());
		add(buttonClose);
		buttonClose.setLayout(null);
		buttonClose.setLocation(parent.getWidth() - buttonClose.getWidth() - 40, 285);
		buttonClose.setTag(tagButtonControl);
		buttonClose.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				System.exit(ABORT);
			}
			
		});
		
		/*PanelMenu panelMenu = new PanelMenu(parent);
		add(panelMenu);
		panelMenu.setLocation(120, 350);*/
		
		buttonMenuOptionNumbers = new ImageButton(parent, Assets.getImageButtonMenuOptionNumbers());
		add(buttonMenuOptionNumbers);
		buttonMenuOptionNumbers.setLayout(null);
		buttonMenuOptionNumbers.setLocation(150, 280);
		buttonMenuOptionNumbers.setTag(tagButtonGame);
	}
	
	public void viewMenuPrincipal(EViewMenuPrincipal e) {
		viewMenuPrincipal = e;
		
		// ocultar todos los botones
		/*for(Component c : this.getComponents()) {
			if(c instanceof ImageButton) {
				c.setVisible(false);
			}
		}*/
		
		boolean showButtonsGame = true;
		
		buttonInfo.setVisible(false);
		buttonBack.setVisible(false);
		
		switch(viewMenuPrincipal) {
			case Info:
				showButtonsGame = false;
				buttonInfo.setVisible(false);
				buttonBack.setVisible(true);
				break;
			default:
				buttonBack.setVisible(false);
				buttonInfo.setVisible(true);
		}
		
		Component[] components = this.getComponents();
		for(Component c : components) {
			if(c instanceof ImageButton) {
				if(((ImageButton) c).getTag() == tagButtonGame) {
					System.out.println(showButtonsGame);
					((ImageButton) c).setVisible(showButtonsGame);
				}		
			}
		}
		
		buttonInfo.getParentGraphicsComponent().repaint();
	}

}

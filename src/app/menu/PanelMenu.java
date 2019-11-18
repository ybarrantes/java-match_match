package app.menu;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import app.Assets;
import enums.EButtonState;
import enums.EButtonType;
import game.GameState;
import listeners.ClickListener;
import ui.ImageButton;

public class PanelMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelMenu(AppFrame parent) {
		super();
		
		setBackground(new Color(0, 0, 0, 0));
		setBounds(0, 0, AppFrame.WIDTH, AppFrame.HEIGHT);
		setLayout(null);
		
		ImageButton buttonSound = new ImageButton(parent, Assets.getImageButtonSoundOn(), Assets.getImageButtonSoundOff());
		buttonSound.setState(EButtonState.ON);
		add(buttonSound);
		buttonSound.setLayout(null);
		buttonSound.setLocation(20, 350);
		buttonSound.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				if(buttonSound.getType() == EButtonType.Check) {
					if(buttonSound.getState() == EButtonState.ON) GameState.mainSound = true;
					else if(buttonSound.getState() == EButtonState.OFF) GameState.mainSound = false;
				}
			}
			
		});
		
		ImageButton buttonMusic = new ImageButton(parent, Assets.getImageButtonMusicOn(), Assets.getImageButtonMusicOff());
		buttonMusic.setState(EButtonState.ON);
		add(buttonMusic);
		buttonMusic.setLayout(null);
		buttonMusic.setLocation(40, 285);
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
		
		
		ImageButton buttonInfo = new ImageButton(parent, Assets.getImageButtonInfo());
		buttonInfo.setState(EButtonState.ON);
		add(buttonInfo);
		buttonInfo.setLayout(null);
		buttonInfo.setLocation(parent.getWidth() - buttonInfo.getWidth() - 20, 350);
		buttonInfo.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				System.out.println("info");
			}
			
		});
		
		
		ImageButton buttonClose = new ImageButton(parent, Assets.getImageButtonClose());
		add(buttonClose);
		buttonClose.setLayout(null);
		buttonClose.setLocation(parent.getWidth() - buttonClose.getWidth() - 40, 285);
		buttonClose.setClickListener(new ClickListener() {

			@Override
			public void onClick(MouseEvent e) {
				System.exit(ABORT);
			}
			
		});
	}

}

package app;

import javax.sound.sampled.Clip;

import enums.ESoundType;
import game.GameState;
import helpers.Sound;

public class AppMusic extends Sound {
	
	private static boolean active;
	@Override
	public boolean isActive() {
		active = GameState.mainMusic;
		return active;
	}

	public AppMusic(Clip clip) {
		super(clip, ESoundType.Music);
	}

}

package app;

import javax.sound.sampled.Clip;

import enums.ESoundType;
import game.GameState;
import helpers.Sound;

public class AppSound extends Sound {
	
	private static boolean active;
	@Override
	public boolean isActive() {
		active = GameState.mainSound;
		return active;
	}

	public AppSound(Clip clip) {
		super(clip, ESoundType.Sound);
	}

}

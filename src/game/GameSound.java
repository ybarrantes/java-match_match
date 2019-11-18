package game;

import javax.sound.sampled.Clip;

import enums.ESoundType;
import helpers.Sound;

public class GameSound extends Sound {
	
	private static boolean active;
	@Override
	public boolean isActive() {
		active = GameState.gameSound;
		return active;
	}

	public GameSound(Clip clip) {
		super(clip, ESoundType.Sound);
	}

}

package game;

import javax.sound.sampled.Clip;

import enums.ESoundType;
import helpers.Sound;

public class GameMusic extends Sound {

	private static boolean active;
	@Override
	public boolean isActive() {
		active = GameState.gameMusic;
		return active;
	}
	
	public GameMusic(Clip clip) {
		super(clip, ESoundType.Music);
	}

}

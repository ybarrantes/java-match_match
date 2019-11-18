package game;

import app.Assets;

public class GameState {
	
	private static boolean initialized = false;
	public static boolean isInitialized() {
		return initialized;
	}

	
	public static boolean mainMusic = false;	
	public static boolean mainSound = false;
	
	public static boolean gameMusic = false;	
	public static boolean gameSound = false;
	

	public static void init() {
		if(!initialized) {
			Assets.init();

			mainMusic = true;
			mainSound = true;
			
			gameMusic = true;
			gameSound = true;
			
			initialized = true;
		}
	}

}

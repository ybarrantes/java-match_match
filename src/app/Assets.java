package app;

import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

public class Assets {
	
	private static boolean initialized = false;
	public static boolean isInitialized() {
		return initialized;
	}
	
	// inicio imagenes
	
	private static BufferedImage imageMainBackground;
	public static BufferedImage getImageMainBackground() {
		return imageMainBackground;
	}
	
	private static BufferedImage imageSplashScreenBackground;
	public static BufferedImage getImageSplashScreenBackground() {
		return imageSplashScreenBackground;
	}
	
	private static BufferedImage imageButtonMusicOn;	
	public static BufferedImage getImageButtonMusicOn() {
		return imageButtonMusicOn;
	}	

	private static BufferedImage imageButtonMusicOff;
	public static BufferedImage getImageButtonMusicOff() {
		return imageButtonMusicOff;
	}
	
	private static BufferedImage imageButtonSoundOn;	
	public static BufferedImage getImageButtonSoundOn() {
		return imageButtonSoundOn;
	}	

	private static BufferedImage imageButtonSoundOff;
	public static BufferedImage getImageButtonSoundOff() {
		return imageButtonSoundOff;
	}
	
	private static BufferedImage imageButtonClose;	
	public static BufferedImage getImageButtonClose() {
		return imageButtonClose;
	}
	
	private static BufferedImage imageButtonInfo;	
	public static BufferedImage getImageButtonInfo() {
		return imageButtonInfo;
	}
	
	private static BufferedImage imageButtonBack;	
	public static BufferedImage getImageButtonBack() {
		return imageButtonBack;
	}
	
	private static BufferedImage imageButtonMenuOptionNumbers;	
	public static BufferedImage getImageButtonMenuOptionNumbers() {
		return imageButtonMenuOptionNumbers;
	}	
	
	// fin imagenes
	
	
	// inicio musica
	
	private static Clip musicMainBackgound;
	public static Clip getMusicMainBackgound() {
		return musicMainBackgound;
	}
	
	// fin musica
	
	// inicio sonidos
	
	private static Clip soundButtonOver;	
	public static Clip getSoundButtonOver() {
		return soundButtonOver;
	}

	private static Clip soundButtonClick;
	public static Clip getSoundButtonClick() {
		return soundButtonClick;
	}
	
	private static Clip soundButtonSwitch;
	public static Clip getSoundButtonSwitch() {
		return soundButtonSwitch;
	}
	
	// fin sonidos
	
	
	
	// carga todos los recursos graficos y de sonido del sistema
	public static void init() {
		if(!initialized) {
			
			imageMainBackground = helpers.Loader.ImageLoader("/images/app/main-background.png");
			imageSplashScreenBackground = helpers.Loader.ImageLoader("/images/app/splash-screen-background.png");
			
			
			imageButtonMusicOn = helpers.Loader.ImageLoader("/images/buttons/button-music-on.png");
			imageButtonMusicOff = helpers.Loader.ImageLoader("/images/buttons/button-music-off.png");			
			imageButtonSoundOn = helpers.Loader.ImageLoader("/images/buttons/button-sound-on.png");
			imageButtonSoundOff = helpers.Loader.ImageLoader("/images/buttons/button-sound-off.png");
			imageButtonClose = helpers.Loader.ImageLoader("/images/buttons/button-close.png");
			imageButtonInfo = helpers.Loader.ImageLoader("/images/buttons/button-info.png");
			imageButtonBack = helpers.Loader.ImageLoader("/images/buttons/button-back.png");
			imageButtonMenuOptionNumbers = helpers.Loader.ImageLoader("/images/buttons/button-menu-option-numbers.png");
			
			
			//musicMainBackgound = helpers.Loader.SoundLoader("/sounds/app/menu-background.wav");
			musicMainBackgound = helpers.Loader.SoundLoader("/sounds/background/happy-ukulele-2.wav");
			
			soundButtonOver = helpers.Loader.SoundLoader("/sounds/app/button-over.wav");
			soundButtonClick = helpers.Loader.SoundLoader("/sounds/app/button-click.wav");
			soundButtonSwitch = helpers.Loader.SoundLoader("/sounds/app/button-switch.wav");
			
			
			initialized = true;
		}
	}
	

}

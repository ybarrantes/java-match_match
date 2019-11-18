package helpers;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import enums.ESoundType;

public abstract class Sound {
	
	private Clip clip;
	
	private boolean pause;
	public boolean isPause() {
		return pause;
	}
	
	private FloatControl volume;
	public FloatControl getVolume() {
		return volume;
	}
	
	private ESoundType type;
	public ESoundType getType() {
		return type;
	}
	

	public Sound(Clip clip, ESoundType type) {
		this.clip = clip;
		this.pause = false;
		this.type = type;
		
		clip.setFramePosition(0);
		volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	
	public abstract boolean isActive();
	
	public void play() {
		if(!isActive()) return;
		
		clip.stop();
		
		if(!pause) {
			clip.setFramePosition(0);
		}
		
		clip.start();
		pause = false;
	}

	public void loop() {
		if(!isActive()) return;
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		pause = false;
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void pause() {
		pause = true;
		stop();
	}
	
	public void changeVolumen(float value) {
		volume.setValue(value);
	}
}

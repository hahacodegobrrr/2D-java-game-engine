package core;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioClip {
	private String name;
	private AudioInputStream inputStream;
	private Clip playbackClip;
	private boolean loopable;

	public AudioClip(String name) {
		this.name = name;
		try {
			playbackClip = AudioSystem.getClip();
			inputStream = AudioSystem.getAudioInputStream(new File("Assets/Audio/" + name + ".wav"));
			playbackClip.open(inputStream);
			((FloatControl)playbackClip.getControl(FloatControl.Type.MASTER_GAIN)).setValue(-5);
		} catch (Exception e) {System.out.println("issue loading audio clip");e.printStackTrace();}
	}
	
	public AudioClip(String name, boolean loopable) {
		this(name);
		this.loopable = loopable;
	}

	public void play() {
		playbackClip.setFramePosition(0);
		playbackClip.start();
		if (loopable) {
			playbackClip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public void stop() {
		playbackClip.stop();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isPlaying() {
		return playbackClip.isActive();
	}
	
}
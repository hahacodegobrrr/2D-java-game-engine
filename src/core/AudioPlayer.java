package core;


import java.util.ArrayList;

public class AudioPlayer {
	
	private ArrayList<AudioClip> audioClips;
	private AudioClip activeClip;
	
	public AudioPlayer() {
		audioClips = new ArrayList<AudioClip>();
	}
	
	public void addClip(String name) {
		addClip(name, false);
	}
	
	public void addClip(String name, boolean loopable) {
		audioClips.add(new AudioClip(name, loopable));
	}
	
	public void playClip(String name) {
		if (activeClip == null || !activeClip.isPlaying()) {
			activeClip = findClip(name);
			if (activeClip != null) {
				activeClip.play();
			}
		}
	}
	
	private AudioClip findClip(String name) {
		for (int i = 0; i < audioClips.size(); i++) {
			if (audioClips.get(i).getName().equals(name)) {
				return audioClips.get(i);
			}
		}
		
		return null;
	}
	
	public void stop() {
		if (activeClip != null) {
			activeClip.stop();
		}
		activeClip = null;
	}
	
	
}

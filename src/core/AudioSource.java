package core;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

//TODO fix this shit

public class AudioSource extends Component {
	
	private static String audioPath = "Assets" + File.separator + "Audio";
	
	private AudioInputStream audioInputStream;
	private Clip clip; //.wav files highly recommended (other supported file types are kinda obscure)
	
	public AudioSource() {
		super(ComponentType.AUDIO_SOURCE);
		play();
	}
	
	public void play() {
		if (clip == null || !clip.isRunning()) {
//			System.out.println("clip over");
			getAudioClip();
		}
		((FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN)).setValue(-20);
	}
	
	private void getAudioClip() {
		try {
			audioInputStream = FileIO.loadAudioStream(FileIO.audioPath + "All Alone blind witness.wav");
			clip = AudioSystem.getClip();
			clip.close();
			clip.open(audioInputStream);
			clip.setMicrosecondPosition(0);
			clip.start();
		} catch (Exception e) {}
	}

	@Override
	public void update(double timeSinceLastUpdate) {}
}

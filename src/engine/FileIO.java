package engine;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class FileIO {
	public static String texturePath = "Assets" + File.separator + "Textures" + File.separator;
	public static String audioPath = "Assets" + File.separator + "Audio" + File.separator;
	
	public static Image loadTexture(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			return null;
		}
	}
	
	public static AudioInputStream loadAudioStream(String path) {
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
		} catch (Exception e) {}
		
		return audioInputStream;
	}
}

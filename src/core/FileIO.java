package core;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class FileIO {
	public static String texturePath = "Assets" + File.separator + "Textures" + File.separator;
	public static String audioPath = "Assets" + File.separator + "Audio" + File.separator;
	
	/**
	 * Load an image from file path
	 * @param path absolute path from program root
	 * @return loaded image
	 */
	public static Image loadTexture(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * Load a .wav file from file path
	 * @param path absolute path to file to .wav file
	 * @return audio input stream
	 */
	public static AudioInputStream loadAudioStream(String path) {
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
		} catch (Exception e) {}
		
		return audioInputStream;
	}
}

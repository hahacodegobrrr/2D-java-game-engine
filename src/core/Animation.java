package core;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Animation {

	private String gameObjectName;
	private String animationName;
	private ArrayList<BufferedImage> frames;
	private int fps;
	private boolean loopable;
	
	/**
	 * File names need to be in the form <game object name>_<animation name>_<frame number>.png
	 * @param gameObjectName
	 * @param animationName
	 */
	public Animation(String gameObjectName, String animationName, int fps) {
		this.gameObjectName = gameObjectName;
		this.animationName = animationName;
		this.fps = fps;
		
		//loops by default
		loopable = true;
		loadFrames();
	}

	public Animation(String gameObjectName, String animationName, int fps, boolean loopable) {
		this(gameObjectName, animationName, fps);
		this.loopable = loopable;
	}
	
	private void loadFrames() {
		frames = new ArrayList<BufferedImage>();
		//scuffed; get rid of this when making an actual engine lmao
		if (animationName.equals("blank") || gameObjectName.equals("number")) {
			try {
				frames.add(ImageIO.read(new File("Assets/Textures/" + animationName + ".png")));
			} catch (Exception e) {}
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (gameObjectName.equals("" + i)) {
				try {
					frames.add(ImageIO.read(new File("Assets/Textures/" + animationName + ".png")));
				} catch (Exception e) {}
				return;
			}
		}
		int numberOfFrames = 0;
		
		//once the last frame has been found, will throw a filenotfound or something and break
		try {
			while (numberOfFrames < 100) {
				frames.add(ImageIO.read(new File("Assets/Textures/" + gameObjectName + "_" + animationName + "_" + numberOfFrames + ".png")));
				numberOfFrames++;
			}
		} catch (Exception e) {}
	}
	
	public BufferedImage getCurrentFrame(double timeSinceAnimationStart) {
		if (frames.size() == 0) {
			return null;
		}
		
		int imageIndex;
		
		if (loopable) {
			imageIndex = (int)(timeSinceAnimationStart * fps) % (frames.size());
		} else {
			imageIndex = Math.min((int)(timeSinceAnimationStart * fps), frames.size() - 1);
		}
		return frames.get(imageIndex);
	}
	
	public String getName() {
		return animationName;
	}
	
	public boolean isLoopable() {
		return loopable;
	}
	
	public void setLoopable(boolean loopable) {
		this.loopable = loopable;
	}
}

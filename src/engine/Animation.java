package engine;
import java.awt.Image;
import java.util.LinkedList;

public class Animation {
	private String name;
	private Image[] animation;
	private int fps;
	private long startTime;
	
	/**
	 * Precondition: files must be named "objectName_animationName_frameNumber.png"
	 * @param objectName name of the GameObject
	 * @param animationName name of animation (eg. "walk")
	 * @param fps frames to be played per second
	 */
	public Animation(String objectName, String animationName, int fps) {
		this.name = animationName;
		int frames = 0;
		LinkedList<Image> frameList = new LinkedList<Image>();
		Image frame = null;
		do {
			frame = FileIO.loadTexture(FileIO.texturePath + objectName + "_" + animationName + "_" + frames + ".png");
			frames++;
			frameList.add(frame);
		} while (frame != null);
		
		//last element will be null		
		frameList.remove(frameList.size() - 1);
		frames--;
		
		animation = (Image[]) frameList.toArray();
		this.fps = fps;
	}
	
	/**
	 * Begins the timer for the animation
	 */
	public void start() {
		startTime = System.nanoTime();
	}
	
	/**
	 * Based on time from animation start, get current frame
	 * @return sprite for current frame
	 */
	public Image getCurrentFrame() {
		double secsSinceStart = (System.nanoTime() - startTime) / 1000000000f;
		int imageIndex = (int)((secsSinceStart * fps) % (animation.length));
		return animation[imageIndex];
	}
	
	/**
	 * name of the animation (eg. "walk", "hit", etc)
	 * @return name of animation
	 */
	public String getName() {
		return name;
	}
}

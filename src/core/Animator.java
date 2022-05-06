package core;


import java.awt.Image;
import java.util.ArrayList;

public class Animator {
	private ArrayList<Animation> animations;
	private Animation runningAnimation;
	
	
	public Animator(String name) {
		animations = new ArrayList<Animation>();
		
	}
	
	/**
	 * Play a certain animation
	 * @param animationName name of the animation
	 */
	public void startAnimation(String animationName) {
		for (int i = 0; i < animations.size(); i++) {
			if (animations.get(i).getName().equals(animationName)) {
				runningAnimation = animations.get(i);
				break;
			}
		}
	}
	
	/**
	 * Gets the current animation frame
	 * @return image of current animation frame
	 */
	public Image getCurrentFrame() {
		return null;
	}
}

package engine;


import java.awt.Image;
import java.util.ArrayList;

public class Animator {
	private ArrayList<Animation> animations;
	private Animation runningAnimation;
	
	
	public Animator(String name) {
		animations = new ArrayList<Animation>();
		
	}
	
	public void startAnimation(String animationName) {
		for (int i = 0; i < animations.size(); i++) {
			if (animations.get(i).getName().equals(animationName)) {
				runningAnimation = animations.get(i);
				break;
			}
		}
	}
	
	public Image getCurrentFrame() {
		return null;
	}
}

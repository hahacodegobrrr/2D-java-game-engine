package core;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator {
	
	private String gameObjectName;
	private Animation activeAnimation;
	private long activeAnimationStartTime;
	
	private ArrayList<Animation> animations;
	
	public Animator(String gameObjectName) {
		this.gameObjectName = gameObjectName;
		animations = new ArrayList<Animation>();
	}
	
	public void addAnimation(String animationName, int fps) {
		animations.add(new Animation(gameObjectName, animationName, fps));
//		System.out.println("added " + animationName + " to " + gameObjectName);
	}
	
	public void addAnimation(String animationName, int fps, boolean loopable) {
		animations.add(new Animation(gameObjectName, animationName, fps, loopable));
	}

	private Animation getAnimation(String animationName) {
		for (int i = 0; i < animations.size(); i++) {
			if (animations.get(i).getName().equals(animationName)) {
				return animations.get(i);
			}
		}
		return null;
	}
	
	public void startAnimation(String name) {
		if (activeAnimation == null || !activeAnimation.getName().equals(name)) {
			activeAnimation = getAnimation(name);
			activeAnimationStartTime = System.nanoTime();
			return;
		}

		if (activeAnimation.getName().equals(name) && !activeAnimation.isLoopable()) {
			activeAnimationStartTime = System.nanoTime();
		}
	}
	
	public BufferedImage getCurrentFrame() {
//		System.out.println(gameObjectName + "_" + activeAnimation.getName());
		if (activeAnimation == null) {
			return null;
		}
		return activeAnimation.getCurrentFrame((System.nanoTime() - activeAnimationStartTime) / 1000000000f);
	}
}

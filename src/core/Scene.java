package core;


import java.awt.Graphics;
import java.util.ArrayList;

public class Scene {
	private String name;
	private ArrayList<GameObject> objects;
	private GameCanvas canvas;
	private AudioSource music;
	private boolean enabled;
	
	public Scene(GameCanvas canvas, String name) {
		this.name = name;
		objects = new ArrayList<GameObject>();
		createGameObjects();
		
		this.canvas = canvas;

		try {
			music = new AudioSource();
		} catch (Exception e) {}
	}
	
	private void createGameObjects() {
		objects.add(new GameObject("tree 2"));
	}
	
	public void update(double timeSinceLastUpdate) {
		if (enabled) {
			for (int i = 0; i < objects.size(); i++) {
				objects.get(i).update(timeSinceLastUpdate);
			}
			if (music != null) {
				music.play();
			}
		}
	}
	
	public void render(Graphics g) {
		if (enabled) {
			for (int i = 0; i < objects.size(); i++) {
				objects.get(i).render(g);
			}
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public void disable() {
		enabled = false;
	}
}

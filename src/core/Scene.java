package core;


import java.awt.Graphics;
import java.util.ArrayList;

public class Scene {
	private String name;
	private ArrayList<GameObject> objects;
	private GameCanvas canvas;
	private AudioSource music;
	private boolean enabled;
	
	/**
	 * Create a new game scene
	 * @param canvas reference to main drawing canvas
	 * @param name name of scene
	 */
	public Scene(GameCanvas canvas, String name) {
		this.name = name;
		objects = new ArrayList<GameObject>();
		
		this.canvas = canvas;

		try {
			music = new AudioSource();
		} catch (Exception e) {}
	}
	
	/**
	 * Add game object to scene
	 * @param gameObject game object
	 */
	public void addGameObject(GameObject gameObject) {
		objects.add(gameObject);
	}
	
	/**
	 * Update all game objects in scene
	 * @param timeSinceLastUpdate time since last frame
	 */
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
	
	/**
	 * Render all game objects in scene
	 * @param g jawt graphics context
	 */
	public void render(Graphics g) {
		if (enabled) {
			for (int i = 0; i < objects.size(); i++) {
				objects.get(i).render(g);
			}
		}
	}
	
	/**
	 * Gets enabled status
	 * @return whether scene is active
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * Sets the scene to enabled
	 */
	public void enable() {
		enabled = true;
	}
	
	/**
	 * Sets the scene to disabled
	 */
	public void disable() {
		enabled = false;
	}
}

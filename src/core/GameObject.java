package core;


import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	private String name;
	private Vector position; //position in world space
	private Vector scale; //size in game units
	
	private Scene myScene;
	
	private SpriteRenderer renderer;
	private AudioPlayer audioPlayer;
	private ArrayList<BoxCollider> colliders;
	
	public GameObject(String name, Vector position, Vector scale, Scene scene) {
		this.name = name;
		this.position = position;
		this.scale = scale;
		myScene = scene;
		colliders = new ArrayList<BoxCollider>();
		renderer = new SpriteRenderer(this);
		audioPlayer = new AudioPlayer();
	}
	
	public void addBoxCollider(BoxCollider collider) {
		colliders.add(collider);
	}
	
	public ArrayList<BoxCollider> getBoxColliders() {
		return colliders;
	}
	
	public void update() {
		//set all colliders to false by default before rescanning
		for (int i = 0; i < colliders.size(); i++) {
			colliders.get(i).setColliding(false);
		}
	}
	
	public void render(Graphics g) {
		renderer.render(g);
		if (RenderFlags.VISIBLE_COLLIDERS) {
			for (BoxCollider collider : colliders) {
				collider.draw(g);
			}
		}
	}
	
	public Scene getScene() {
		return myScene;
	}
	
	public SpriteRenderer getSpriteRenderer() {
		return renderer;
	}
	
	public AudioPlayer getAudioPlayer() {
		return audioPlayer;
	}
	
	public String getName() {
		return name;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public void setPosition(Vector v) {
		this.position = v;
	}
	
	public Vector getScale() {
		return scale;
	}
}

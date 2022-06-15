package core;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteRenderer {
	
	private Animator animator;
	
	private GameObject parent;
	
	public SpriteRenderer(GameObject parent) {
		this.parent = parent;
		animator = new Animator(parent.getName());
	}
	
	/**
	 * Fetches the animator of the game object
	 * @return animator instance of game object
	 */
	public Animator getAnimator() {
		return animator;
	}
	
	/**
	 * Paints sprite of game object on canvas
	 * @param g
	 */
	public void render(Graphics g) {
		BufferedImage sprite = animator.getCurrentFrame();
		if (sprite != null && !RenderFlags.NO_TEXTURES) {
			g.drawImage(sprite, 
					(int)(parent.getPosition().getX() - (parent.getScale().getX() / 2)), 
					(int)(parent.getPosition().getY() - (parent.getScale().getY() / 2)), 
					(int)parent.getScale().getX(),
					(int)parent.getScale().getY(),
					null);
		} else {
			g.setColor(Color.magenta);
			g.fillRect((int)(parent.getPosition().getX() - (parent.getScale().getX() / 2)),
					(int)(parent.getPosition().getY() - (parent.getScale().getY() / 2)),
					(int)parent.getScale().getX(),
					(int)parent.getScale().getY());
			g.setColor(Color.black);
			g.drawRect((int)(parent.getPosition().getX() - (parent.getScale().getX() / 2)),
					(int)(parent.getPosition().getY() - (parent.getScale().getY() / 2)),
					(int)parent.getScale().getX(),
					(int)parent.getScale().getY());
		}
	}
}

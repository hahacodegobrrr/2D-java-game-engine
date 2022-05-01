

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteRenderer extends Component {

	private static String texturePath = "Assets" + File.separator + "Textures";
	private Animator animator;
	
	
	public SpriteRenderer(String name) {
		super(ComponentType.SPRITE_RENDERER);
		animator = new Animator(name);
		
		
	}
	
	/**
	 * renders the current frame of animation
	 * @param g jawt graphics context
	 * @param position 
	 * @param scale
	 */
	public void render(Graphics g, Vector position, Vector scale) {
		Image currentTexture = animator.getCurrentFrame();
		g.drawImage(currentTexture.getScaledInstance((int)scale.x + 1, (int)scale.y + 1, BufferedImage.TYPE_INT_ARGB), (int)position.x, (int)position.y, null);
	}

	/**
	 * technically doesn't do anything, everything should happen in render()
	 */
	@Override
	public void update(double timeSinceLastUpdate) {}
}

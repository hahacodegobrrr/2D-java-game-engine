

import java.awt.Graphics;
import java.util.LinkedList;


public class GameObject extends Component implements Drawable {

	public Vector position;
	
	private Vector scale; //number of pixels on screen
	
	private String name;
	
	private LinkedList<Component> components;
	
	public GameObject(String name) {
		super(ComponentType.GAME_OBJECT);
		position = new Vector();
		scale = new Vector(1000, 1000);
		this.components = new LinkedList<Component>();
	}
	
	/**
	 * Add a component to the game object
	 * @param component reference to component
	 */
	public void addComponent(Component component) {
		if (component != null) components.add(component);
	}
	
	/**
	 * Updates the game object and every component in the game object
	 * @param timeSinceLastUpdate seconds between updates
	 */
	public void update(double timeSinceLastUpdate) {
		position.x = Math.cos(Time.timer.timeSinceStart() * 10) * 100;
		position.y = Math.sin(Time.timer.timeSinceStart() * 10) * 100;
		
		for (int i = 0; i < components.size(); i++) {
			
		}
	}
	
	/**
	 * Render the game object by calling render function in sprite renderer component
	 */
	@Override
	public void render(Graphics g) {
		for (int i = 0; i < components.size(); i++) {
			if (components.get(i).getComponentType() == ComponentType.SPRITE_RENDERER) {
				((SpriteRenderer)components.get(i)).render(g, position, scale);
				break;
			}
		}
	}

}

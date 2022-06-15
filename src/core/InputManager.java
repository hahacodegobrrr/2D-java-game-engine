package core;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

	//there should only ever be one input manager at a time
	private static InputManager globalInputManager;
	private static boolean moveUp;
	private static boolean moveDown;
	private static boolean moveLeft;
	private static boolean moveRight;
	private static boolean attack;
	private static boolean repair;
	private static boolean drop;
	private static boolean one;
	private static boolean two;
	private static boolean three;
	private static boolean four;
	private static boolean five;
	private static boolean enter;

	private static GameCanvas canvas;
	
	/**
	 * Creates a singleton input manager
	 * @param canvas JPanel that input manager will listen to
	 */
	public static void initializeInputManager(GameCanvas canvas) {
		if (canvas != null) {
			InputManager.canvas = canvas;
			if (globalInputManager == null) {
				globalInputManager = new InputManager();
			}
		}
	}
	
	/**
	 * Return whether or not a certain action button has been pressed
	 * @param key key to be checked
	 * @return whether or not specified key has been pressed
	 */
	public static boolean getKey(KeyCode key) {
		switch (key) {
			case MOVE_LEFT:
				return moveLeft;
			case MOVE_RIGHT:
				return moveRight;
			case MOVE_UP:
				return moveUp;
			case MOVE_DOWN:
				return moveDown;
			case ATTACK:
				return attack;
			case REPAIR:
				return repair;
			case DROP:
				return drop;
			case ONE:
				return one;
			case TWO:
				return two;
			case THREE:
				return three;
			case FOUR:
				return four;
			case FIVE:
				return five;
			case ENTER:
				return enter;
			default:
				return false;
		}
	}

	/**
	 * Uncouples input manager from game canvas (GC removes automatically)
	 */
	public static void destroyInputManager() {
		if (globalInputManager != null && canvas != null) {
			canvas.removeKeyListener(globalInputManager);
			globalInputManager = null;
		}
		
		//reset variables?
	}
	
	/**
	 * Private constructor to avoid outside instantiation
	 * @param canvas JPanel input manager will listen to
	 */
	private InputManager() {
		canvas.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				moveUp = true;
				break;
			case KeyEvent.VK_A:
				moveLeft = true;
				break;
			case KeyEvent.VK_S:
				moveDown = true;
				break;
			case KeyEvent.VK_D:
				moveRight = true;
				break;
			case KeyEvent.VK_J:
				attack = true;
				break;
			case KeyEvent.VK_K:
				repair = true;
				break;
			case KeyEvent.VK_Q:
				drop = true;
				break;
			case KeyEvent.VK_1:
				one = true;
				break;
			case KeyEvent.VK_2:
				two = true;
				break;
			case KeyEvent.VK_3:
				three = true;
				break;
			case KeyEvent.VK_4:
				four = true;
				break;
			case KeyEvent.VK_5:
				five = true;
				break;
			case KeyEvent.VK_ENTER:
				enter = true;
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				moveUp = false;
				break;
			case KeyEvent.VK_A:
				moveLeft = false;
				break;
			case KeyEvent.VK_S:
				moveDown = false;
				break;
			case KeyEvent.VK_D:
				moveRight = false;
				break;
			case KeyEvent.VK_J:
				attack = false;
				break;
			case KeyEvent.VK_K:
				repair = false;
				break;
			case KeyEvent.VK_Q:
				drop = false;
				break;
			case KeyEvent.VK_1:
				one = false;
				break;
			case KeyEvent.VK_2:
				two = false;
				break;
			case KeyEvent.VK_3:
				three = false;
				break;
			case KeyEvent.VK_4:
				four = false;
				break;
			case KeyEvent.VK_5:
				five = false;
				break;
			case KeyEvent.VK_ENTER:
				enter = false;
				break;
			default:
				break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
}

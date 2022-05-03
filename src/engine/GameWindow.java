package engine;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private GameCanvas mainCanvas;
	private Vector size;
	private boolean resizable;
	
	public GameWindow(String name, int width, int height, boolean resizeable) {
		super(name);
		size = new Vector(width, height);
		this.resizable = false;
		initializeWindow();
	}
	
	private void initializeWindow() {
		mainCanvas = new GameCanvas();
		setSize((int)size.x, (int)size.y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(resizable);
		
		setContentPane(mainCanvas);
		setVisible(true);

		mainCanvas.requestFocusInWindow();
	}
}

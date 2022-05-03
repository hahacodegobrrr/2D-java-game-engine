package core;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private GameCanvas mainCanvas;
	
	public GameWindow(String name, int width, int height, boolean resizeable) {
		super(name);
		
		//initialize window
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(resizeable);
		setVisible(true);
		
		mainCanvas = new GameCanvas();
		setContentPane(mainCanvas);

		mainCanvas.requestFocusInWindow();
	}
}

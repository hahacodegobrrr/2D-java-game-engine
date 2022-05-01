import javax.swing.JFrame;

public class GameLauncher {
	public static void main(String[] args) {
		GameWindow gameWindow = new GameWindow("yes");
		GameCanvas gameCanvas = new GameCanvas();
		
		
		gameWindow.setSize(1280, 720);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false);
		gameWindow.setVisible(true);
		gameWindow.setContentPane(gameCanvas);
		
		gameCanvas.requestFocusInWindow();
	}
}

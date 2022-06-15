package core;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameClock implements ActionListener {

	//only one clock should be running at a time
	private static GameClock globalClock;
	private static Timer internalTimer;
	private static long gameStartTime;
	private static long currentTime;
	private static double timeSinceLastUpdate;
	private static GameCanvas canvas;
	
	/**
	 * Creates a singleton game clock
	 * @param canvas JPanel that clock calls update() on
	 */
	public static void initializeGameClock(GameCanvas canvas) {
		if (canvas != null) {
			GameClock.canvas = canvas;
			if (globalClock == null) {
				globalClock = new GameClock();
			}
		}
	}
	
	/**
	 * Start updating the canvas
	 */
	public static void startClock() {
		currentTime = System.nanoTime();
		gameStartTime = System.nanoTime();
		internalTimer.start();
	}
	
	/**
	 * Get the time since the clock started
	 * @return time, in seconds, since clock start
	 */
	public static double timeSinceClockStart() {
		long nanos = System.nanoTime() - gameStartTime;
		return nanos / 1000000000f;
	}
	
	/**
	 * Get the time since the last canvas update call
	 * @return time, in seconds, since last update
	 */
	public static double timeSinceLastUpdate() {
		return timeSinceLastUpdate;
	}
	
	/**
	 * Stop updating the canvas
	 */
	public static void stopClock() {
		internalTimer.stop();
	}
	
	/**
	 * Sets the game time to 0
	 */
	public static void resetClock() {
		gameStartTime = System.nanoTime();
	}
	
	/**
	 * Destroy current game clock instance
	 */
	public static void destroyGameClock() {
		globalClock = null;
		internalTimer = null;
		gameStartTime = 0;
		currentTime = 0;
		timeSinceLastUpdate = 0;
		canvas = null;
	}
	
	/**
	 * Private to avoid external instantiation
	 */
	private GameClock() {
		//supposed to have ~60tps but seems to be dependent on other factors as well
		internalTimer = new Timer(8, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timeSinceLastUpdate = (System.nanoTime() - currentTime) / 1000000000f;
		currentTime = System.nanoTime();
		canvas.update();
		canvas.render();
//		System.out.println(1 / timeSinceLastUpdate);
	}

}

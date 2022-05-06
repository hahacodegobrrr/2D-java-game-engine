package core;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Time implements ActionListener {
	
	public static Time timer;
	
	private long lastTimeRecord;
	private GameCanvas canvas;
	private long startTime;
	
	/**
	 * Create and start a new timer
	 * @param canvas main game canvas
	 */
	public Time(GameCanvas canvas) {
		if (timer != null) {
			return;
		}
		timer = this;
		this.canvas = canvas;
		lastTimeRecord = System.nanoTime();
		
		//trying to run at ~60fps, changes depending on computer
		Timer frameClock = new Timer(8, this);
		
		frameClock.start();
	}

	/**
	 * Called by event timer
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("update");
		canvas.update();
	}
	
	/**
	 * Meant for finding time between frames
	 * @return time, in seconds, since last method call
	 */
	public double timeSinceLastCall() {
		long currentTime = System.nanoTime();
		double diff = (currentTime - lastTimeRecord) / 1000000000f;
		lastTimeRecord = currentTime;
		
		return diff;
	}
	
	/**
	 * Return time since the current instance of the timer was started
	 * @return time since timer start, in seconds
	 */
	public double timeSinceStart() {
		return (System.nanoTime() - startTime) / 1000000000f;
	}
	
	/**
	 * Delete static reference, release memory
	 */
	public static void destroy() {
		timer = null;
	}
}

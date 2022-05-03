package engine;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Time implements ActionListener {
	
	public static Time timer;
	
	private long lastTimeRecord;
	private GameCanvas canvas;
	private long startTime;
	
	public Time(GameCanvas canvas) {
		if (timer != null) {
			return;
		}
		timer = this;
		this.canvas = canvas;
		lastTimeRecord = System.nanoTime();
		
		//trying to run at ~60fps
		Timer frameClock = new Timer(8, this);
		
		frameClock.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("update");
		canvas.update();
	}
	
	public double timeSinceLastCall() {
		long currentTime = System.nanoTime();
		double diff = (currentTime - lastTimeRecord) / 1000000000f;
		lastTimeRecord = currentTime;
		
		return diff;
	}
	
	public double timeSinceStart() {
		return (System.nanoTime() - startTime) / 1000000000f;
	}
	
}

package core;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameCanvas extends JPanel {
	
	private double frameRate = 0;
	private ArrayList<Scene> scenes;
	
	public GameCanvas(int width, int height) {
		setSize(width, height);
		new Time(this);
		scenes = new ArrayList<Scene>();
		scenes.add(new Scene(this, "game"));
		repaint();
	}
	
	/**
	 * Called by timer every game tick
	 */
	public void update() {
		frameRate = 1/Time.timer.timeSinceLastCall();
		for (int i = 0; i < scenes.size(); i++) {
			if (scenes.get(i).isEnabled()) {
				scenes.get(i).update(1 / frameRate);
			}
		}
		repaint();
	}
	
	/**
	 * Render canvas
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//draw scenes
		for (int i = 0; i < scenes.size(); i++) {
			scenes.get(i).render(g);
		}
//		System.out.println("paint component");
		renderDebug(g);
	}
	
	/**
	 * Display debug information
	 * @param g jawt graphics context
	 */
	private void renderDebug(Graphics g) {
//		System.out.println("rendering debug screen");
		g.drawString(""+frameRate, 20, 20);
	}
}

package core;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
	private ArrayList<Scene> scenes;
	private Scene activeScene;
	
	public GameCanvas(int width, int height) {
		super.setSize(width, height);
		scenes = new ArrayList<Scene>();
		InputManager.initializeInputManager(this);
	}
	
	public void addScene(Scene scene) {
		scenes.add(scene);
	}
	
	public Scene removeScene(String name) {
		for (int i = 0; i < scenes.size(); i++) {
			if (scenes.get(i).getName().equals(name)) {
				return scenes.remove(i);
			}
		}
		return null;
	}
	
	public void update() {
//		System.out.println(1 / GameClock.timeSinceLastUpdate() + " updates/second");
		for (Scene s : scenes) {
			s.update();
		}
	}
	
	public void render() {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (activeScene != null && activeScene.getName().equals("main")) {
			super.setBackground(Color.white);
		} else {
			super.setBackground(new Color(150, 255, 255));
		}
		super.paintComponent(g);
		for (int i = 0; i < scenes.size(); i++) {
			scenes.get(i).render(g);
		}
		
		if (RenderFlags.STATS_OVERLAY) {
			g.setColor(Color.black);
			g.drawString("" + 1 / GameClock.timeSinceLastUpdate(), 20, 20);
			g.drawString("" + GameClock.timeSinceClockStart(), 20, 40);
		}
	}
	
	public Scene getScene(String name) {
		for (Scene s : scenes) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		
		return null;
	}
	
	public Scene getActiveScene() {
		return activeScene;
	}
	
	public void setActiveScene(Scene scene) {
		activeScene = scene;
	}
}

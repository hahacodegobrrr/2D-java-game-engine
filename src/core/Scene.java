package core;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene {
	
	private boolean active;
	private String name;
	private List<GameObject> gameObjects;
	private ArrayList<GameObject> ui;
	
	public Scene(String name) {
		gameObjects = new ArrayList<GameObject>();
		ui = new ArrayList<GameObject>();
		this.name = name;
	}
	
	public void addGameObject(GameObject g) {
		if (g != null) {
			gameObjects.add(g);
		}
	}
	
	public void addUIElement(GameObject g) {
		ui.add(g);
	}
	
	/**
	 * Update scene objects if active
	 */
	public void update() {
		if (active) {
			for (int i = 0; i < gameObjects.size(); i++) {
				gameObjects.get(i).update();
			}
		}
	}
	
	/**
	 * Render scene objects if active
	 * @param g graphics context
	 */
	public void render(Graphics g) {
		if (active) {
//			System.out.println("new frame =============");
			gameObjects = sortGameObjectsByDistanceFromCamera(gameObjects);
			
			//negative z is farthest from the cam, render first
			for (int i = 0; i < gameObjects.size(); i++) {
				gameObjects.get(i).render(g);
			}
			
			//render the ui stuff last
			for (int i = 0; i < ui.size(); i++) {
				ui.get(i).render(g);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Finds a game object by name
	 * @param name name of game object
	 * @return game object if found, otherwise null
	 */
	public GameObject getGameObject(String name) {
		for (GameObject g : gameObjects) {
			if (g.getName().equals(name)) {
				return g;
			}
		}
		
		return null;
	}
	
	/**
	 * removes a game object from the scene
	 * @param g game object instance to be removed
	 */
	public void removeGameObject(GameObject g) {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (g == gameObjects.get(i)) {
				gameObjects.remove(i);
				return;
			}
		}
	}
	
	/**
	 * Called when the player tries to hit something
	 */
	public void attemptHit() {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i) instanceof Hittable 
					&& ((Hittable)gameObjects.get(i)).withinHittingDistance()) {
				((Hittable)gameObjects.get(i)).hit();
			}
		}
	}
	
	public void enable() {
		active = true;
	}
	
	public void disable() {
		active = false;
	}
	
	
	//utility methods
	
	private static List<GameObject> sortGameObjectsByDistanceFromCamera(List<GameObject> objects) {
		GameObject[] gameObjects = new GameObject[objects.size()];
		GameObject[] temp = new GameObject[objects.size()];
		
		for (int i = 0; i < objects.size(); i++) {
			gameObjects[i] = objects.get(i);
		}
		
		for (int mergeBlockSize = 1; mergeBlockSize < gameObjects.length; mergeBlockSize *= 2) {
			
			//for *attempted* speed optimization
			int doubleMergeBlock = mergeBlockSize * 2;
			
			//will be the largest merge index possible given the current merge block size
			int extraMergeStart = gameObjects.length - (gameObjects.length % doubleMergeBlock);
			
			//merge everything except section at the end (if not base 2)
			for (int blockStart = 0; blockStart < extraMergeStart; blockStart += doubleMergeBlock) {
				merge(gameObjects, temp, blockStart, blockStart + mergeBlockSize, blockStart + doubleMergeBlock);
			}

			//merges the sorted elements at the end with the last sorted block (only affects non base 2 length arrays)
			if (extraMergeStart < gameObjects.length && extraMergeStart != 0) {
				merge(gameObjects, temp, extraMergeStart - doubleMergeBlock, extraMergeStart, gameObjects.length);
			}
		}
		
		objects = new ArrayList<GameObject>();
		
		for (int i = 0; i < gameObjects.length; i++) {
			objects.add(gameObjects[i]);
//			System.out.println(gameObjects[i].getName() + ": " + gameObjects[i].getPosition().getZ());
		}
		
		return objects;
	}

	private static void merge(GameObject[] objects, GameObject[] temp, int lStart, int rStart, int rEnd) {
		int l = lStart;
		int r = rStart;
		
		//iterate and merge from main to temp
		int i = lStart;
		while (l != rStart && r != rEnd) {
			if (objects[l].getPosition().getZ() < objects[r].getPosition().getZ()) {
				temp[i++] = objects[l++];
			} else if (objects[r].getPosition().getZ() < objects[l].getPosition().getZ()) {
				temp[i++] = objects[r++];
			} else {
				temp[i++] = objects[l++];
				temp[i++] = objects[r++];
			}
		}
		
		if (l != rStart) {
			for (int j = l; j < rStart; j++) {
				temp[i++] = objects[j];
			}
		} else if (r != rEnd) {
			for (int j = r; j < rEnd; j++) {
				temp[i++] = objects[j];
			}
		}

		//copy back to main
		for (int j = lStart; j < rEnd; j++) {
			objects[j] = temp[j];
		}
	}
}

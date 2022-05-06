package core;
public class Camera {
	
	public static final int texturePixelsPerUnit = 16;
	public static final int screenPixelsPerUnit = 16;
	
	private Vector pos;
	
	private Vector viewRange; //in game units
	
	public Camera(Vector viewRange) {
		this.viewRange = viewRange;
	}
	
	/**
	 * Move the camera by a certain amount
	 * @param dPos change in position
	 */
	public void move(Vector dPos) {
		pos = Vector.add(pos, dPos);
	}
	
	/**
	 * Get the current camera position in worldspace
	 * @return camera position
	 */
	public Vector getPos() {
		return pos;
	}
}

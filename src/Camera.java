public class Camera {
	private Vector pos;
	
	private Vector viewRange; //in game units
	
	public Camera(Vector viewRange) {
		this.viewRange = viewRange;
	}
	
	public void move(Vector dPos) {
		pos = Vector.add(pos, dPos);
	}
	
	public Vector getPos() {
		return pos;
	}
}

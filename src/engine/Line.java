package engine;


public class Line {
	private Vector a, b;
	
	public Line(Vector a, Vector b) {
		this.a = a;
		this.b = b;
	}
	
	public Vector[] getPoints() {
		return new Vector[] {a, b};
	}
}

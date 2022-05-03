package core;
public class Vector {
	public double x, y, z;
	
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(double x, double y) {
		this(x, y, 0);
	}
	
	public Vector() {
		this(0, 0, 0);
	}
	
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	public static Vector add(Vector a, Vector b) {
		return new Vector(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	
	public static Vector multiply(Vector a, int b) {
		return new Vector(a.x * b, a.y * b);
	}
}

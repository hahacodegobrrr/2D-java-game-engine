package core;
public class Vector {
	public double x, y, z;
	
	/**
	 * Create a three dimensional vector
	 * @param x horizontal component
	 * @param y vertical component
	 * @param z depth component
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Create a two dimensional vector
	 * @param x horizontal component
	 * @param y vertical component
	 */
	public Vector(double x, double y) {
		this(x, y, 0);
	}
	
	/**
	 * Create a new vector with default values of 0
	 */
	public Vector() {
		this(0, 0, 0);
	}
	
	/**
	 * String representation of vector
	 */
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	/**
	 * Add two vectors together
	 * @param a first vector
	 * @param b second vector
	 * @return new vector with calculated values
	 */
	public static Vector add(Vector a, Vector b) {
		return new Vector(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	
	/**
	 * Multiply vector by scalar
	 * @param a vector factor
	 * @param b scalar factor
	 * @return new vector with calculated values
	 */
	public static Vector multiply(Vector a, int b) {
		return new Vector(a.x * b, a.y * b);
	}
}

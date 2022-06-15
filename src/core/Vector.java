package core;


/**
 * Representation of a two or three dimensional vector
 */
public class Vector {
	private double x, y, z;
	
	/**
	 * Create a three dimensional vector
	 * @param x horizontal component
	 * @param y vertical component
	 * @param z depth component
	 */
	public Vector(double x,double y, double z) {
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
	 * Create an empty vector -> (0, 0, 0) by default
	 */
	public Vector() {
		this(0, 0, 0);
	}
	
	/**
	 * Add components of two vectors
	 * @param a first vector
	 * @param b second vector
	 * @return new vector with requested values
	 */
	public static Vector add(Vector a, Vector b) {
		return new Vector(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	
	/**
	 * Subtract the components of one vector from another
	 * @param a first vector
	 * @param b subtracted vector
	 * @return new vector with requested values
	 */
	public static Vector subtract(Vector a, Vector b) {
		return new Vector(a.x - b.x, a.y - b.y, a.z - b.z);
	}
	
	/**
	 * Multiply a vector by a scalar value
	 * @param a vector
	 * @param scalar scalar value
	 * @return new vector with requested values
	 */
	public static Vector multiply(Vector a, double scalar) {
		return new Vector(a.x * scalar, a.y * scalar, a.z * scalar);
	}
	
	/**
	 * Find the length of a vector
	 * @param v vector
	 * @return the length of the vector
	 */
	public static double length2D(Vector v) {
		return Math.sqrt((v.x * v.x) + (v.y * v.y));
	}
	
	/**
	 * Find the length of a vector in 3d space
	 * @param v vector
	 * @return the length of the vector
	 */
	public static double length3D(Vector v) {
		return Math.sqrt((v.x * v.x) + (v.y * v.y) + (v.z * v.z));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}
}

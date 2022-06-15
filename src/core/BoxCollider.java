package core;


import java.awt.Color;
import java.awt.Graphics;

public class BoxCollider {
	private double leftEdge, rightEdge, topEdge, bottomEdge;
	private Vector pos, size;
	private boolean collidingWithSomething;
	
	/**
	 * Create a box collider
	 * @param x center x coordinate
	 * @param y center y coordinate
	 * @param width total width of collider
	 * @param height total height of collider
	 */
	public BoxCollider(double x, double y, double width, double height) {
		pos = new Vector(x, y);
		size = new Vector(width, height);
		leftEdge = x - (width / 2);
		rightEdge = x + (width / 2);
		topEdge = y - (height / 2);
		bottomEdge = y + (height / 2);
	}
	
	//for debugging purposes
	public void draw(Graphics g) {
		if (collidingWithSomething) {
			g.setColor(Color.red);
		} else {
			g.setColor(Color.black);
		}
		g.drawRect((int)leftEdge, (int)topEdge, (int)size.getX(), (int)size.getY());
	}
	
	/**
	 * Test to see whether two box colliders are overlapping
	 * @param collider collider to be compared
	 * @return whether or not the two boxes overlap
	 */
	public boolean isCollidingWith(BoxCollider collider) {
		if (bottomEdge < collider.getTopEdge()
			|| topEdge > collider.getBottomEdge()
			|| rightEdge < collider.getLeftEdge()
			|| leftEdge > collider.getRightEdge()) {
			return false;
		}
		return true;
	}
	
	public void setPosition(double x, double y) {
		double oldX = pos.getX();
		double oldY = pos.getY();
		pos.setX(x);
		pos.setY(y);
		leftEdge += x - oldX;
		rightEdge += x - oldX;
		topEdge += y - oldY;
		bottomEdge += y - oldY;
	}
	
	public void setColliding(boolean colliding) {
		collidingWithSomething = colliding;
	}
	
	public boolean collisionState() {
		return collidingWithSomething;
	}
	
	public Vector getPosition() {
		return pos;
	}
	
	public double getLeftEdge() {
		return leftEdge;
	}
	
	public double getRightEdge() {
		return rightEdge;
	}

	public double getTopEdge() {
		return topEdge;
	}

	public double getBottomEdge() {
		return bottomEdge;
	}
	
	public String toString() {
		return "Pos: " + pos + " Size: " + size;
	}
}

package core;


public interface Hittable {
	/**
	 * Perform an action when hit by the player
	 */
	void hit();	

	/**
	 * Calculate hitting distance from player and return if is within this range
	 */
	boolean withinHittingDistance();
}

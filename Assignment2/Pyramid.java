/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 22;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 15;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 19;
	
	private int bottomLineOfCurrentRow;
	private int currentLevelLeftWall;
	
	public void run() {
		currentLevelLeftWall = getWidth()/2 - ((BRICKS_IN_BASE/2))*BRICK_WIDTH;
		for(int i=1; i<=BRICKS_IN_BASE;i++) {
			bottomLineOfCurrentRow = getHeight() - BRICK_HEIGHT*i;
			for(int j=0; j<=(BRICKS_IN_BASE - i);j++){
				buildBrick();
				currentLevelLeftWall = currentLevelLeftWall + BRICK_WIDTH;
			} 
			currentLevelLeftWall = getWidth()/2 - (BRICKS_IN_BASE/2)*BRICK_WIDTH + (BRICK_WIDTH/2)*i;
		} 
	} 
	
	public void buildBrick() {
		GRect brick = new GRect(currentLevelLeftWall, bottomLineOfCurrentRow, BRICK_WIDTH,BRICK_HEIGHT);
		add(brick);
	}
}
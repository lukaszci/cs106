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

public class PyramidLR extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 31;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 11;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 20;
	
	public void run() {
		int baseLenght = (BRICKS_IN_BASE/2)*BRICK_WIDTH;
		int brickPossition;
		int BOTTOM_LINE_OF_CURRENT_ROW;
		for(int i=0; i<=BRICKS_IN_BASE;i++) {
			brickPossition = getWidth()/2 - baseLenght + (BRICK_WIDTH/2)*i;
			BOTTOM_LINE_OF_CURRENT_ROW = getHeight() - BRICK_HEIGHT*i;
			for(int j=0; j<=(BRICKS_IN_BASE - i);j++){
				add(buildBrick(brickPossition, BOTTOM_LINE_OF_CURRENT_ROW));
				brickPossition += BRICK_WIDTH;
			} 
		} 
	} 
	
	public GRect buildBrick(int currentLevel, int bottom) {
		return new GRect(currentLevel,bottom,BRICK_WIDTH,BRICK_HEIGHT);
		
	}
}

/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	private int bottomLineOfCurrentRow;
	private int currentBrickLeftSide;
	private Color currentColor;

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		setupBricks();
		createPaddle();
	}

	public void setupBricks() {
		bottomLineOfCurrentRow = BRICK_SEP;
		currentBrickLeftSide = BRICK_SEP;
		for (int i = 1; i <= NBRICKS_PER_ROW; i++) {
			bottomLineOfCurrentRow = bottomLineOfCurrentRow + BRICK_HEIGHT + BRICK_SEP;
			if (i <= 2) {
				currentColor = Color.RED;
			} else if (i <= 4) {
				currentColor = Color.ORANGE;
			}
			else if (i <= 6) {
				currentColor = Color.YELLOW;
			}
			else if (i <= 8) {
				currentColor = Color.GREEN;
			}
			else if (i <= 10) {
				currentColor = Color.CYAN;
			}
			for (int j = 1; j <= NBRICKS_PER_ROW; j++) {

				buildBrick(currentColor);
				currentBrickLeftSide = currentBrickLeftSide + BRICK_WIDTH + BRICK_SEP;
			}
			currentBrickLeftSide = BRICK_SEP;
		}
	}

	public void buildBrick(Color c) {
		GRect brick = new GRect(currentBrickLeftSide, bottomLineOfCurrentRow, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		brick.setFilled(true);
		brick.setColor(c);
	}

	public void createPaddle() {
		GRect paddle = new GRect(APPLICATION_WIDTH/2 - PADDLE_WIDTH/2, APPLICATION_HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
		add(paddle);
		paddle.setFilled(true);
	}

	public void createBall() {

	}

	public void checkForCollisions() {

	}

}

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
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
	private static final int PADDLE_WIDTH = 70;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 1;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 3;

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
	private static int NTURNS = 3;

	private static final double GRAVITY = 6;

	private int remainingBricks = NBRICK_ROWS * NBRICKS_PER_ROW;
	private int remainingLifeCount = NTURNS;
	private int bottomLineOfCurrentRow;
	private int currentBrickLeftSide;
	private double vx;
	private double vy = GRAVITY;
	private static final int DELAY = 20;
	private Color currentColor;
	private GOval ball;
	private GRect brick;
	private GRect paddle;
	private GObject collider;
	private GLabel lostLife;
	private GLabel middleText;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		setup();
		pause(4000);
		while (remainingBricks > 0 && remainingLifeCount >= 0) {
			playGame();
			if (ball.getY() >= HEIGHT) {
				userLostLife();
				pause(4999);
			}
			if (remainingBricks == 0) {
				userWon();
			}
		}
	}

	private void setup() {
		showWelcomeText();
		createBricks();
		createPaddle();
		createBall();
		addMouseListeners();
	}
	
	/**
     * Controls building rows of bricks in different colors.
     */

	public void createBricks() {
		bottomLineOfCurrentRow = BRICK_Y_OFFSET + BRICK_HEIGHT;
		currentBrickLeftSide = BRICK_SEP;
		for (int i = 1; i <= NBRICK_ROWS; i++) {
			bottomLineOfCurrentRow = bottomLineOfCurrentRow + BRICK_HEIGHT + BRICK_SEP;
			if (i <= 2) {
				currentColor = Color.RED;
			} else if (i <= 4) {
				currentColor = Color.ORANGE;
			} else if (i <= 6) {
				currentColor = Color.YELLOW;
			} else if (i <= 8) {
				currentColor = Color.GREEN;
			} else if (i <= 10) {
				currentColor = Color.CYAN;
			}
			for (int j = 1; j <= NBRICKS_PER_ROW; j++) {

				buildBrick(currentColor);
				currentBrickLeftSide = currentBrickLeftSide + BRICK_WIDTH + BRICK_SEP;
			}
			currentBrickLeftSide = BRICK_SEP;
		}
	}
	
	/**
     * Defines a unified format of a brick. Ensures that all bricks are the same size and can be colored.
     */

	public void buildBrick(Color c) {
		brick = new GRect(currentBrickLeftSide, bottomLineOfCurrentRow, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		brick.setFilled(true);
		brick.setColor(c);
	}

	public void createPaddle() {
		paddle = new GRect(WIDTH / 2 - PADDLE_WIDTH / 2, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		add(paddle);
		paddle.setFilled(true);
	}

	public void createBall() {
		ball = new GOval(WIDTH / 2, HEIGHT / 2, BALL_RADIUS, BALL_RADIUS);
		add(ball);
		ball.setColor(Color.GREEN);
		ball.setFilled(true);
	}
	
	/**
     * Defines the way that ball will be moving. 
     */
	
	private void moveBall() {
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5))
			vx = -vx;//makes the ball bounce off the object in the opposite vertical direction
		ball.move(vx, vy);
		if (ballHitTheVerticallWall()) {
			vx = -vx;//makes the ball bounce off the object in the opposite vertical direction
		}
		if (ballHitTheTopWall()) {
			vy = -vy;//makes the ball bounce off the object in the opposite vertical direction
		}
	}
	
	/**
     * Enables paddle to react to mouse movement only horizontally and only within the game board.
     */

	public void mouseMoved(MouseEvent e) {
		if (e.getX() <= WIDTH && e.getX() >= 0 + PADDLE_WIDTH) {
			paddle.setLocation(e.getX() - PADDLE_WIDTH, HEIGHT - PADDLE_Y_OFFSET);
		}
	}

	/**
     * Let's user to make the ball appear on click only. Also with a click user can hide any text in the middle.
     */
	
	public void mouseClicked(MouseEvent e) {
		if (ball == null && remainingLifeCount >= 0) {
			createBall();
		}
		if (remainingLifeCount == NTURNS && middleText.isVisible()) {
			remove(middleText);
		}
		if (remainingLifeCount < NTURNS && lostLife.isVisible()) {
			remove(lostLife);
		}
	}

	public void checkForCollisions() {
		getCollidingObjects();
		if (isThereACollider() && (collider != paddle)) {
			remove(collider);
			vy = -vy;
			remainingBricks = remainingBricks - 1;
		} else if (collider == paddle) {
			vy = -vy;
		}
	}

	private boolean ballHitTheVerticallWall() {
		boolean hitVertical = ball.getX() <= (WIDTH - BALL_RADIUS) || ball.getX() >= 0 + BALL_RADIUS;
		return hitVertical;
	}

	private boolean ballHitTheTopWall() {
		boolean hitTop = ball.getY() <= 0;
		return hitTop;
	}

	private boolean isThereACollider() {
		if (collider != null) {
			return true;
		} else
			return false;
	}

	private GObject getCollidingObjects() {
		return collider = getElementAt(ball.getX(), ball.getY());
	}

	public void playGame() {
		moveBall();
		checkForCollisions();
		pause(DELAY);
	}

	public void showWelcomeText() {
		middleText = new GLabel("Welcome to the game. Click to choose your first ball");
		add(middleText, WIDTH / 2 - middleText.getWidth() / 2, HEIGHT / 2);
	}

	private void userWon() {
		GLabel youWon = new GLabel("You won the game. Have a glass of water to celebrate", WIDTH/2, HEIGHT/2);
		add(youWon, WIDTH/2 - youWon.getWidth()/2, HEIGHT/2);
	}

	private void userLostLife() {
		remove(ball);
		ball = null;
		remainingLifeCount = remainingLifeCount - 1;
		System.out.println(remainingLifeCount);
		if (remainingLifeCount >= 2) {
			lostLife = new GLabel("You lost a life. You got " + remainingLifeCount + " lifes left!");
			add(lostLife, WIDTH/2 - lostLife.getWidth()/2, HEIGHT/2);
		} else if (remainingLifeCount == 1) {
			lostLife = new GLabel("You lost a life. You got 1 life left!");
			add(lostLife, WIDTH/2 - lostLife.getWidth()/2, HEIGHT/2);
		} else if (remainingLifeCount == 0) {
			lostLife = new GLabel("You lost a life. This is your last chance.");
			add(lostLife, WIDTH/2 - lostLife.getWidth()/2, HEIGHT/2);
		} else {
			lostLife = new GLabel("You lost the game. Have a great day");
			add(lostLife, WIDTH/2 - lostLife.getWidth()/2, HEIGHT/2);
		}
	}
}
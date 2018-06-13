/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	private GOval head;
	private GLabel guessed;
	private String guessedSoFar = "";

/** Resets the display so that only the scaffold appears */
	public void reset() {
		addScaffold();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		guessedSoFar = guessedSoFar + letter;
		listIncorrectLetters();
		/*System.out.println(guessedSoFar.length());
		guessed = new GLabel(guessedSoFar + letter);
		System.out.println(guessedSoFar.length());*/
		if (guessedSoFar.length() == 1) {
			addHead();
		}
		if (guessedSoFar.length() == 2) {
			addBody();
		}
		if (guessedSoFar.length() == 3) {
			addLeftArm();
		}
		if (guessedSoFar.length() == 4) {
			addRightArm();
		}
		if (guessedSoFar.length() == 5) {
			addLeftLeg();
		}
		if (guessedSoFar.length() == 6) {
			addRightLeg();
		}
		if (guessedSoFar.length() == 7) {
			addLeftFoot();
		}
		if (guessedSoFar.length() == 8) {
			addRightFoot();
		}
		
 	}
	
	private void addScaffold() {
		GLine pole = new GLine(getWidth()/4,getHeight()/4,getWidth()/4,getHeight()/4*3);
		add(pole);
		GLine beam = new GLine(222,212,211,112);
		add(beam);
	}
	
	private void addRope() {
		GLine rope = new GLine(1,2,1,2);
		add(rope);
	}
	
	private void addHead() {
		GOval head = new GOval(100,200,100,200);
		add(head);
	}
	
	private void addBody() {
		GLine hips = new GLine(50,20,40,70);
		add(hips);
		GLine spine = new GLine(20, 50, 40, 70);
		add(hips);
		GLine shoulders = new GLine(70, 50, 40, 20);
		add(hips);
	}
	
	private void addLeftArm() {
		GLine lArm = new GLine(1,2,1,2);
		add(lArm);
	}
	
	private void addRightArm() {
		GLine rArm = new GLine(1,2,1,2);
		add(rArm);
	}
	
	private void addLeftLeg() {
		GLine lLeg = new GLine(1,2,1,2);
		add(lLeg);
	}
	
	private void addRightLeg() {
		GLine rLeg = new GLine(1,2,1,2);
		add(rLeg);
	}
	
	private void addLeftFoot() {
		GLine lFoot = new GLine(1,2,1,2);
		add(lFoot);
	}
	
	private void addRightFoot() {
		GLine rFoot = new GLine(1,2,1,2);
		add(rFoot);
	}
	
	private void listIncorrectLetters() {
		guessed = new GLabel(guessedSoFar,50,200);
		add(guessed);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
}
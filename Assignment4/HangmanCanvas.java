/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	private String guessedWrongSoFar = "";

/** Resets the display so that only the scaffold appears */
	public void reset() {
		addScaffold();
	}
	
	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game.  The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
	 */

	public void noteCorrectGuess(String g) {
		double x = getWidth()/4;
		double y = getHeight() - HEAD_RADIUS*2;
		GLabel correct = new GLabel(g, x, y);
		correct.setFont("Halvetica-24");
		if (getElementAt(x,y) != null){
			remove(getElementAt(x,y));
		}
		add(correct);
	}
	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user.  Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	
	public void noteIncorrectGuess(char letter) {
		guessedWrongSoFar = guessedWrongSoFar + letter;
		listIncorrectLetters();
		if (guessedWrongSoFar.length() == 1) {
			addHead();
		}
		if (guessedWrongSoFar.length() == 2) {
			addBody();
		}
		if (guessedWrongSoFar.length() == 3) {
			addLeftArm();
		}
		if (guessedWrongSoFar.length() == 4) {
			addRightArm();
		}
		if (guessedWrongSoFar.length() == 5) {
			addLeftLeg();
		}
		if (guessedWrongSoFar.length() == 6) {
			addRightLeg();
		}
		if (guessedWrongSoFar.length() == 7) {
			addLeftFoot();
		}
		if (guessedWrongSoFar.length() == 8) {
			addRightFoot();
		}
		
 	}
	
	public void addScaffold() {
		double scaffoldTopX = getWidth()/4 - UPPER_ARM_LENGTH;
		double scaffoldTopY = getHeight()/2  - BODY_LENGTH - HEAD_RADIUS*2 - ROPE_LENGTH;
		double scaffoldBottomY = scaffoldTopY + SCAFFOLD_HEIGHT;
		GLine scaffold= new GLine (scaffoldTopX, scaffoldTopY, scaffoldTopX, scaffoldBottomY);
		add(scaffold);
		double beamRightX = scaffoldTopX + BEAM_LENGTH;
		GLine beam = new GLine(scaffoldTopX, scaffoldTopY, beamRightX, scaffoldTopY);
		add(beam);
		double ropeBottomY = scaffoldTopY + ROPE_LENGTH;
		GLine rope = new GLine (beamRightX, scaffoldTopY, beamRightX, ropeBottomY);
		add(rope);
	}
	
	private void addHead() {
		double x = getWidth()/2 - UPPER_ARM_LENGTH + BEAM_LENGTH - HEAD_RADIUS;
		double y = getHeight()/2 - BODY_LENGTH - HEAD_RADIUS*2;
		GOval head = new GOval (x, y, HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}
	
	private void addBody() {
		double x = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double topY = getHeight()/2 - BODY_LENGTH;
		double bottomY = topY + BODY_LENGTH;
		GLine body = new GLine (x, topY, x, bottomY);
		add(body);
	}
	
	private void addLeftArm() {
		double armStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double armEndX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS - UPPER_ARM_LENGTH;
		double upperArmHeightY = getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		GLine upperLeftArm = new GLine (armStartX, upperArmHeightY, armEndX, upperArmHeightY);
		add(upperLeftArm);
		double lowerArmEndY = upperArmHeightY + LOWER_ARM_LENGTH;
		GLine lowerLeftArm = new GLine (armEndX, upperArmHeightY, armEndX, lowerArmEndY);
		add(lowerLeftArm);
	}
	
	private void addRightArm() {
		double armStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double armEndX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS + UPPER_ARM_LENGTH;
		double upperArmHeightY = getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		GLine upperRightArm = new GLine (armStartX, upperArmHeightY, armEndX, upperArmHeightY);
		add(upperRightArm);
		double lowerArmEndY = upperArmHeightY + LOWER_ARM_LENGTH;
		GLine lowerRightArm = new GLine (armEndX, upperArmHeightY, armEndX, lowerArmEndY);
		add(lowerRightArm);
	}
	
	private void addLeftLeg() {
		double hipStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double hipEndX = hipStartX - HIP_WIDTH;
		double hipHeightY = getHeight()/2;
		GLine leftHip = new GLine(hipStartX, hipHeightY, hipEndX, hipHeightY);
		add(leftHip);
		double leftLegY = hipHeightY + LEG_LENGTH;
		GLine leftLeg = new GLine(hipEndX, hipHeightY, hipEndX, leftLegY);
		add(leftLeg);
	}
	
	private void addRightLeg() {
		double hipStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double hipEndX = hipStartX + HIP_WIDTH;
		double hipHeightY = getHeight()/2;
		GLine leftHip = new GLine(hipStartX, hipHeightY, hipEndX, hipHeightY);
		add(leftHip);
		double leftLegEndY = hipHeightY + LEG_LENGTH;
		GLine leftLeg = new GLine(hipEndX, hipHeightY, hipEndX, leftLegEndY);
		add(leftLeg);
	}
	
	private void addLeftFoot() {
		double footStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS - HIP_WIDTH;
		double footEndX = footStartX - FOOT_LENGTH;
		double footHeightY = getHeight()/2 + LEG_LENGTH;
		GLine leftFoot = new GLine(footStartX, footHeightY, footEndX, footHeightY);
		add(leftFoot);
	}
	
	private void addRightFoot() {
		double footStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS + HIP_WIDTH;
		double footEndX = footStartX + FOOT_LENGTH;
		double footHeightY = getHeight()/2 + LEG_LENGTH;
		GLine rightFoot = new GLine(footStartX, footHeightY, footEndX, footHeightY);
		add(rightFoot);
	}
	
	private void listIncorrectLetters() {
		GLabel incorrect = new GLabel(guessedWrongSoFar, 100, 200);
		add(incorrect);
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
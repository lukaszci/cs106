/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		int value = 1;
		int lowestvalue = 0;
		int highestvalue = 0;
		while (value !=0 ) {
			value = readInt("give me a number: ");
			if (value > highestvalue || value!=0) {
				highestvalue = value;
			} else if (value < lowestvalue || value!=0) {
				lowestvalue = value;
			} else if (value == 0) {
				println("smallest value entered was: " + lowestvalue);
				println("largest value entered was: " + highestvalue);
				break;
			}
		}
	}
}
/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	public void run() {
		println("Enter values to calculate Pythagorean theorem");
		int a = readInt("Provide length of the first side of the triangle in inches:");
		int b = readInt("Provide length of the second side of the triangle in inches:");
		double c =  Math.sqrt(a*a + b*b); 
		println("The third side of the triangle is " +  c + " inches long");
	}
}

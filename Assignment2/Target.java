/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Target extends GraphicsProgram {	

	private static final long serialVersionUID = 1L;
	private static final double OUTERMOST_CIRCLE_RADIUS = 662;
	private static final double MIDDLE_CIRCLE_RADIUS = OUTERMOST_CIRCLE_RADIUS*0.65;
	private static final double INNERMOST_CIRCLE_RADIUS = OUTERMOST_CIRCLE_RADIUS*0.3;
	public void run() {
		drawOutermostCircle();
		drawMiddleCircle();
		drawInnermostCircle();
	}
	
	public void drawOutermostCircle() {
		GOval outc = new GOval(getWidth()/2 - OUTERMOST_CIRCLE_RADIUS/2,getHeight()/2 - OUTERMOST_CIRCLE_RADIUS/2,OUTERMOST_CIRCLE_RADIUS,OUTERMOST_CIRCLE_RADIUS);
		outc.setColor(Color.RED);
		outc.setFilled(true);
		add(outc);
	}
	
	public void drawMiddleCircle() {
		GOval midc = new GOval(getWidth()/2  - MIDDLE_CIRCLE_RADIUS/2,getHeight()/2  - MIDDLE_CIRCLE_RADIUS/2,MIDDLE_CIRCLE_RADIUS ,MIDDLE_CIRCLE_RADIUS);
		midc.setFilled(true);
		midc.setColor(Color.WHITE);
		add(midc);
	}

	public void drawInnermostCircle() {
		GOval inc = new GOval(getWidth()/2 - INNERMOST_CIRCLE_RADIUS/2,getHeight()/2 - INNERMOST_CIRCLE_RADIUS/2,INNERMOST_CIRCLE_RADIUS,INNERMOST_CIRCLE_RADIUS);
		inc.setColor(Color.RED);
		inc.setFilled(true);
		add(inc);
	}
}

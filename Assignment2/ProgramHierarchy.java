/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final long serialVersionUID = 1L;
	private static final int BOX_HEIGHT = 60;
	private static final int BOX_WIDTH = 170; 
	private static final String PROGRAM = "Program";
	private static final String GRAPHICS_PROGRAM = "GraphicsProgram";
	private static final String CONSOLE_PROGRAM = "ConsoleProgram";
	private static final String DIALOG_PROGRAM = "DialogProgram";
	public void run() {
		makeAndConnectLeftBottomBox();
		makeAndConnectMiddleBottomBox();
		makeAndConnectRightBottomBox();
		makeTopBox();
	}
	
	public void makeLabels() {
		GLabel prog = new GLabel(PROGRAM,1,2);
		prog.getAscent();
		prog.getWidth();
		add(prog);
	}
	
	public void makeTopBox() {
		GLabel pr = new GLabel(PROGRAM);
		pr.setLocation(getWidth()/4*2 - pr.getWidth()/2,getHeight()/6 + BOX_HEIGHT);
		add(pr);
		GRect box = new GRect(getWidth()/4*2 - BOX_WIDTH/2,getHeight()/6 + BOX_HEIGHT/2,BOX_WIDTH,BOX_HEIGHT);
		add(box);
	}
	
	public void makeAndConnectLeftBottomBox() {
		GLabel gr = new GLabel(GRAPHICS_PROGRAM);
		gr.setLocation(getWidth()/4 - gr.getWidth()/2,getHeight()/6*4 + BOX_HEIGHT);
		add(gr);
		GLine lli = new GLine(getWidth()/4,getHeight()/6*4 + BOX_HEIGHT/2,getWidth()/2,getHeight()/6*2);
		add(lli);
		GRect box = new GRect(getWidth()/4 - BOX_WIDTH/2,getHeight()/6*4 + BOX_HEIGHT/2,BOX_WIDTH,BOX_HEIGHT);
		add(box);
	}
	
	public void makeAndConnectMiddleBottomBox() {
		GLabel co = new GLabel(CONSOLE_PROGRAM);
		co.setLocation(getWidth()/4*2 - co.getWidth()/2,getHeight()/6*4 + BOX_HEIGHT);
		add(co);
		GLine mli = new GLine(getWidth()/2,getHeight()/6*4 + BOX_HEIGHT/2,getWidth()/2,getHeight()/6*2);
		add(mli);
		GRect box = new GRect(getWidth()/2 - BOX_WIDTH/2,getHeight()/6*4 + BOX_HEIGHT/2,BOX_WIDTH,BOX_HEIGHT);
		add(box);
	}
	
	public void makeAndConnectRightBottomBox() {
		GLabel dia = new GLabel(DIALOG_PROGRAM);
		dia.setLocation(getWidth()/4*3 - dia.getWidth()/2,getHeight()/6*4 + BOX_HEIGHT);
		add(dia);
		GLine rli = new GLine(getWidth()/4*3,getHeight()/6*4 + BOX_HEIGHT/2,getWidth()/2,getHeight()/6*2);
		add(rli);
		GRect box = new GRect(getWidth()/4*3 - BOX_WIDTH/2,getHeight()/6*4 + BOX_HEIGHT/2,BOX_WIDTH,BOX_HEIGHT);
		add(box);
	}
}
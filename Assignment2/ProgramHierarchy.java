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
		createBoxWithText(GRAPHICS_PROGRAM, 1, 0.5, BOX_HEIGHT);
		createBoxWithText(CONSOLE_PROGRAM, 2, 0.5, BOX_HEIGHT);
		createBoxWithText(DIALOG_PROGRAM, 3, 0.5, BOX_HEIGHT);
		createBoxWithText(PROGRAM, 2, - 1.5, - BOX_HEIGHT);
		drawLine(1);
		drawLine(2);
		drawLine(3);
	}

	public void createBoxWithText(String program, int incrementWidth, double incrementHeight, int textAllignment) {
		GLabel lab = new GLabel(program);
		lab.setLocation(getWidth()/4*incrementWidth - lab.getWidth()/2,getHeight()/2 + textAllignment);
		add(lab);
		GRect box = new GRect(getWidth()/4*incrementWidth - BOX_WIDTH/2, getHeight()/2 + BOX_HEIGHT*incrementHeight, BOX_WIDTH, BOX_HEIGHT);
		add(box);
	}
	
	public void drawLine(int incrementWidth) {
		GLine line = new GLine(getWidth()/4*incrementWidth, getHeight()/2 + BOX_HEIGHT*0.5, getWidth()/2,getHeight()/2 - BOX_HEIGHT/2);
		add(line);
	}
}
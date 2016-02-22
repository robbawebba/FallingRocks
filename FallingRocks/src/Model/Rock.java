package Model;

import ascii.ASCIIScreen;

public class Rock extends GameObjects {

	private int x;
	private int y;
	private int rockSize;

	// We need static variables from ASCIIScreen to be imported
	final int WIDTH = ASCIIScreen.getWidth();
	final int HEIGHT = ASCIIScreen.getHeight();
	StringBuilder[] screen = ASCIIScreen.getScreen();

	public Rock(int x, int rockSize) {
		y = 0;
		this.x = x;
		this.rockSize = rockSize;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRockSize() {
		return rockSize;
	}

	public void updateYPosition() {
		y += 1;
	}
	
	public void updatePosition(){
		screen[y].setCharAt(x, '\\');
		screen[y].setCharAt(x + 1, '/');
		ASCIIScreen.setScreen(screen);
	}

}

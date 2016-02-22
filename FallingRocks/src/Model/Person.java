package Model;

import ascii.ASCIIScreen;

public class Person extends GameObjects {

	private int x;
	private int y;
	private int size = 1;
	public char personHead = 'O';
	public char personBody = '+';
	public char personLegs = '^';

	// We need static variables from ASCIIScreen to be imported
	final int WIDTH = ASCIIScreen.getWidth();
	final int HEIGHT = ASCIIScreen.getHeight();
	StringBuilder[] screen = ASCIIScreen.getScreen();

	public Person(int xPos) {
		x = xPos;
		y = WIDTH - 3;
	}

	public int getX() {
		return this.x;
	}

	public void moveLeft() {
		if (x > 1) {
			x = x - 1;
		}
	}

	public void moveRight() {
		x = x + 1;
	}

	public int getSize() {
		return size;
	}

	public int getY() {
		return y;
	}

	public void updatePosition() {
		// Have to put person on the screen
		StringBuilder line;
		line = new StringBuilder("");
		for (int i = 0; i < WIDTH; i++) {
			line.append(' ');
		}
		line.setCharAt(x, personHead);
		screen[y] = line;

		line = new StringBuilder("");
		for (int i = 0; i < WIDTH; i++) {
			line.append(' ');
		}
		line.setCharAt(x, personBody);
		screen[y + 1] = line;

		line = new StringBuilder("");
		for (int i = 0; i < WIDTH; i++) {
			line.append(' ');
		}
		line.setCharAt(x, personLegs);
		screen[y + 2] = line;
		
		ASCIIScreen.setScreen(screen);
	}

}

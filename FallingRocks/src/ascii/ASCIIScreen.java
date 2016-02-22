package ascii;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * Code for this class currently runs a local main() for testing (shows a ball
 * moving across the screen) or operates with ASCIIGameTemplate main() to allow
 * keyboard input (see allowed chars below) to move the ball right.
 **/

public class ASCIIScreen {

	private static StringBuilder[] screen;
	static StringBuilder line;
	static StringBuilder blank;
	private final static int WIDTH = 80;
	private final static int HEIGHT = 24;

	static Timer timer = new Timer();
	int level = 1;
	public static Person person;
	
	private static boolean isTerminated = true;

	/*******************************************************************
	 * Constructor - initializes screen and line
	 *******************************************************************/
	ASCIIScreen() {

		setScreen(new StringBuilder[HEIGHT]);

		blank = new StringBuilder();
		blank.setLength(WIDTH);
		for (int i = 0; i < WIDTH; i++){
			blank.append(' ');
		}

		for (int i = 0; i < HEIGHT; i++)
			getScreen()[i] = new StringBuilder(blank); // WHY?

		line = new StringBuilder("");
		for (int i = 0; i < WIDTH / 2; i++) {
			line.append('\\'); 
			line.append('/');
			screen[0] = line;
		}

	}

	/*******************************************************************
	 * Print the current state.
	 *******************************************************************/
	void printScreen() {

		for (int j = 0; j < HEIGHT; j++)
			System.out.println(screen[j]);
		System.out.println(line);
	}

	/***************************************************
	 * Getter for person object
	 ***************************************************/

	public static Person getPerson() {
		return person;
	}

	/********************************************************************
	 * Initialize game pieces.
	 ********************************************************************/

	void init() {
		isTerminated = false;
		person = new Person(40);
		person.updatePosition();

		// Create timer to make rocks start to fall
		timer.scheduleAtFixedRate(new fallRock(), System.currentTimeMillis(),
				(long) (400.0 / level));
	}

	/********************************************************************
	 * Have game respond to a single character input.
	 ********************************************************************/
	void processChar(int c) {
		switch (c) {
		case 'j':
			person.moveLeft();
		case 'l':
			person.moveRight();
		case 's':
			if (isTerminated){
				
				//If the game is stopped, create a new blank board
				setScreen(new StringBuilder[HEIGHT]);

				blank = new StringBuilder("");
				for (int i = 0; i < WIDTH; i++)
					blank.insert(1, ' ');

				for (int i = 0; i < HEIGHT; i++)
					getScreen()[i] = new StringBuilder(blank); // WHY?

				line = new StringBuilder("");
				for (int i = 0; i < WIDTH / 2; i++) {
					line.append('\\');
					line.append('/');
					screen[0] = line;
				}
				//initialize the game
				init();
			}
			
		case 'q':
			ASCIIGameTemplate.terminateApplication = true;
			
		}

	}

	/********************************************************************
	 * Terminate Game
	 ********************************************************************/

	public static void terminate() {
		isTerminated = true;
		timer.cancel();

		// Change string builder to show just
		// GAME OVER
		// SCORE: *score here*
		// press s to play again
		
	}

	
	//Getters and setters for private static variables

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static StringBuilder[] getScreen() {
		return screen;
	}

	public static void setScreen(StringBuilder[] screen) {
		ASCIIScreen.screen = screen;
	}
	
	//Getter for isTerminated which is used as a condition in the game template
	
	public static boolean getIsTerminated(){
		return isTerminated;
	}
}

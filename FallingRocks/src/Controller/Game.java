package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import jline.ConsoleReader;
import View.Screen;

public class Game {
	static Screen screen; 
//	static GameLogic game;

	public static void main(String[] args) throws IOException {
        Character mask = null;         
        String trigger = null;
        
        screen = new Screen();
        
        ConsoleReader reader = new ConsoleReader(System.in, new PrintWriter(System.out));
        char[] allowed = {'i','j','k','l','q'}; screen.init(); 
        try {
        	int i = 0;     
        	while(i != 'q') { 
        		i = reader.readCharacter(allowed);
        		System.out.println(i);
//        		game.processChar(i); 
        		screen.printScreen(); 
        		TimeUnit.MILLISECONDS.sleep(100);
        	} 
        } catch (InterruptedException e) {
        	e.printStackTrace();
    	}
	
	}
}

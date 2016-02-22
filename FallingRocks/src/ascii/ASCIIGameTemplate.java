/*  * Copyright (c) 2002-2006, Marc Prud'hommeaux. All rights reserved.  *  * This software is distributable under the BSD license. See the terms of the  * BSD license in the documentation provided with this software.  */ package ascii;
import java.util.concurrent.*;

import jline.*;

import java.io.*;
/************************************************************  * This code wraps an ASCII game so that we can process individual  * char inputs (otherwise, Java only likes to process whole lines  * followed by "enter" key).  ************************************************************/
public class ASCIIGameTemplate {     
	static ASCIIScreen game; 
	static boolean terminateApplication = false;
	
	public static void main(String[] args) throws IOException {
        
        game = new ASCIIScreen();
        
        ConsoleReader reader = new ConsoleReader(System.in, new PrintWriter(System.out));
        char[] allowed = {'i','j','k','l','q','s'}; 
        
        try {
        	game.init(); 
            game.printScreen();
            TimeUnit.MILLISECONDS.sleep(100);
        	int i = 0; 
        	while (!terminateApplication) { 
        		i = reader.readCharacter(allowed);
        		System.out.println(i);
        		game.processChar(i); 
        		ASCIIScreen.person.updatePosition();

				//Print the updated screen, then wait 100 milliseconds
        		game.printScreen(); 
        		TimeUnit.MILLISECONDS.sleep(100);
        	} 
        } catch (InterruptedException e) {
        	e.printStackTrace(); }
    	} 
	}
     
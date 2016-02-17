package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Board {
	private final int WIDTH= 80;
	private final int HEIGHT = 24;
	private char[][] gameBoard;
	private Collection<Rock> rocks;
	
	public Board() {
		this.gameBoard = new char[HEIGHT][WIDTH];
		for(int i= 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				gameBoard[i][j] = '-';
			}		
		}
		rocks = new ArrayList<Rock>() ;
	}
	
	public void print() {
		for(int i= 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();			
		}
		System.out.println();
	}
	
	private void addRock() {
		int rand = (int) Math.floor(Math.random()*80);
		Rock rock = new Rock(rand, rand%3);
		rocks.add(rock);
	}
	
	public void fillBoard() {
		Rock tempRock = null;
		for(Iterator<Rock> it = rocks.iterator(); it.hasNext();) {
			if (it.hasNext()) 
				 tempRock = it.next();
				gameBoard[tempRock.getY()][tempRock.getX()] = 'O';
		}		
	}
		
	public static void main(String[] args) {
		Board board = new Board();
		board.print();
		board.addRock();
		board.fillBoard();
		board.print();
	}

}

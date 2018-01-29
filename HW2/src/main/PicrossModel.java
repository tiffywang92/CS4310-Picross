package main;

import java.util.ArrayList;
import java.util.Random;
import GameBoard.java;

/**
 * The Model component manages the system data and associated operations on that data.
 * This will be a passive model that has it's data "pulled" by the view and controller,
 * rather than an active one that can "push" updates to the controller and view.
 *
 */
public class PicrossModel {
	
	private GameBoard solutionB;
	private GameBoard userB;
	private ArrayList<ArrayList<Integer>> trueX;
	private ArrayList<ArrayList<Integer>> trueY;
	
	/**
	 * Creates a random game board and stores it in solutionB.
	 * @param gameSize - the size of the 2d square game board
	 */
	private void generateSolution(int gameSize) {
		// Check for grid size
		if (gameSize < 4)
			gameSize = 4;	// set minimum grid size; cannot be less than 4 for gameplay purposes
					// i.e. a grid size of 2 or 3 makes too small a square for an array of hints
					// a size of 1 or less doesn't make a grid
		
		// Create randomnized grid
		Random r = new Random(); 
		for (int y = 0 ; y < gameSize ; y++)
			for ( int x = 0 ; x < gameSize ; x++) 
				solutionB[x][y] = r.nextInteger();

		//  Reset User Grid
		for (int y = 0 ; y < gameSize ; y++)
			for ( int x = 0 ; x < gameSize ; x++) 
				userB[x][y] = 0;   
	}
	
	/**
	 * Generates the hints for solutionB and stores them in trueX and trueY.
	 */
	private void generateTrueXY(int gameSize) {
		// Check for grid size
		if (gameSize < 4)
			gameSize = 4;
		
		// Reset hint grid to 0
		for (int y = 0 ; y < gameSize ; y++)
			if (gameSize % 2 == 0)
				for ( int x = 0 ; x < gameSize / 2 ; x++) {
					trueX[y][x] = 0;
					trueY[y][x] = 0;
			else
				for ( int x = 0 ; x < gameSize / 2 + 1 ; x++) {
					trueX[y][x] = 0;
					trueY[y][x] = 0;
			}
		}

		//Compute x-axis hint
		int tempCount = 0;
		for (int y = 0 ; y < gameSize ; y++) {
		    for ( int x = 0 ; x < gameSize ; x++) {
			if (solutionB[y][x] == 1)
			    trueX[y][tempCount] ++;		//Found box true, up the hint count
			else if (trueX[y][0] !=0 && solutionB[y][x] == 0)
			tempCount  = 1; 	// Found box false and previous is not true, move to 2nd element
			else;  //box false, do nothing
		    }
		    tempCount = 0;   
		}	

		tempCount = 0;  //reset count for picking up y-axis hint

		//Compute y-axis hint
		for ( int x = 0 ; x < gameSize ; x++) {
		    for (int y = 0 ; y < gameSize ; y++) {
			if (solutionB[y][x] == 1)
			    trueY[x][tempCount] ++;		//Found box true, up the hint count
			else if (trueY[x][0] !=0 && solutionB[y][x] == 0)
			    tempCount  = 1; 	// Found box false and previous is not true, move to 2nd element
			else;	//box false, do nothing
		    }
		    tempCount = 0;
		}
	}
	
	/**
	 * Constructor, initializes all values by generating a random play grid and corresponding hints.
	 * @param gameSize - the size to make the 2d square game board
	 */
	public PicrossModel(Integer gameSize) {
		// Should setSquareUserBoard be used to determine gameSize?
		generateSolution(gameSize);	// Load solution grid
		generateTrueXY(gameSize);	// Load hint grid
		// What is the purpose of getHints if generateTrueXY will load them automatically?
		if (!isCorrect) {
			// draw the user board
			// Do we leave this here or to the View instead?
		}
	}
	
	/**
	 * Sets a square on the user board.
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setSquareUserBoard(Integer x, Integer y, Integer value) {
		userB.setSquare(x, y, value);
	}
	
	/**
	 * This returns a copy of either the X column hints or Y column hints.
	 * @param xOrY - 0 for the X column hints, anything else for Y column hints
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> getHints(Integer xOrY){
		//Note currently does not return a copy so over writing may occur
		if(xOrY == 0) {
			return trueX;
		}else {
			return trueY;
		}
	}
	
	/**
	 * Checks and compares the solution to the current user board.
	 * @return - true if the user's board matches the solution, false otherwise.
	 */
	public boolean isCorrect() {
		boolean correct = true;  //correct flag

		for (int i = 0; i<solutionB.length; i++){
		    for (int j = 0; j<solutionB[i].length; j++){
			if(solutionB[i][j] != userB[i][j]){
			    correct = false;
			}
		    }
		}

		if(correct){
		    System.out.println("Correct!");
		    return correct;
		}
		else{
		    System.out.println("Incorrect!");
		    //print user Grid and solution Grid
		    return correct;
		}
		
		return false;
	}
	
}

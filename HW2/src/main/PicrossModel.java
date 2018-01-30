package main;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Model component manages the system data and associated operations on that data.
 * This will be a passive model that has it's data "pulled" by the view and controller,
 * rather than an active one that can "push" updates to the controller and view.
 *
 */
public class PicrossModel {
	
	private GameBoard solutionB;
	private GameBoard userB;
	private Integer modelSize;
	private ArrayList<ArrayList<Integer>> rowHints;
	private ArrayList<ArrayList<Integer>> columnHints;
	
	/**
	 * Creates a random game board and stores it in solutionB.
	 * @param gameSize - the size of the 2d square game board
	 */
	private void generateSolution(int gameSize) {
		
		// Create randomnized grid
		Random r = new Random(); 
		for (int y = 0 ; y < gameSize ; y++)
			for ( int x = 0 ; x < gameSize ; x++) {
				if (r.nextInt(2) == 1)
					solutionB.setSquare(x, y, 'o');
				else
					solutionB.setSquare(x, y, ' ');
			}

		//  Reset User Grid
		for (int y = 0 ; y < gameSize ; y++)
			for ( int x = 0 ; x < gameSize ; x++) 
				userB.setSquare(x, y, ' ');
	}
	
	/**
	 * Generates the hints for solutionB and stores them in trueX and trueY.
	 */
	private void generateTrueXY(int gameSize) {
		
//		// Reset hint grid to 0
//		for (int y = 0 ; y < gameSize ; y++)
//			if (gameSize % 2 == 0)		//If size is even
//				for ( int x = 0 ; x < gameSize / 2 ; x++) {
//					trueX[y][x] = 0;
//					trueY[y][x] = 0;
//			else				//If size is odd
//				for ( int x = 0 ; x < gameSize / 2 + 1 ; x++) {
//					trueX[y][x] = 0;
//					trueY[y][x] = 0;
//			}
//		}

		//Compute row hints
		int tempCount = 0;
		for (int x = 0 ; x < gameSize ; x++) {
			rowHints.add(new ArrayList<Integer>());
		    for ( int y = 0 ; y < gameSize ; y++) {
		    	if(solutionB.getBoardValue(x, y) == 'o') {
		    		++tempCount;	//Found box true, up the hint count
		    	}else {
		    		if(tempCount != 0) {
		    			rowHints.get(x).add(tempCount);
		    		}
		    		tempCount = 0;
		    	}
		    }
		    if(tempCount == 0 && rowHints.get(x).size() == 0) {
		    	rowHints.get(x).add(tempCount);
		    }
		    if(tempCount != 0) {
		    	rowHints.get(x).add(tempCount);
		    	tempCount = 0;
		    }
		}

		tempCount = 0;  //reset count for picking up y-axis hint

		//Compute column hints
		for ( int y = 0 ; y < gameSize ; y++) {
			columnHints.add(new ArrayList<Integer>());
		    for (int x = 0 ; x < gameSize ; x++) {
		    	if(solutionB.getBoardValue(x, y) == 'o') {
		    		++tempCount;	//Found box true, up the hint count
		    	} else {
		    		if(tempCount != 0) {
		    			columnHints.get(y).add(tempCount);
		    		}
		    		tempCount = 0;
		    	}
		    }
		    if(tempCount == 0 && columnHints.get(y).size() == 0) {
		    	columnHints.get(y).add(tempCount);
		    }
		    if(tempCount != 0) {
		    	columnHints.get(y).add(tempCount);
		    	tempCount = 0;
		    }
		}
		
	}
	
	/**
	 * Constructor, initializes all values by generating a random play grid and corresponding hints.
	 * @param gameSize - the size to make the 2d square game board
	 */
	public PicrossModel(Integer gameSize) {
		// Check for grid size
		// set minimum grid size; cannot be less than 4 for gameplay purposes, more than 10 is unwieldy
		// i.e. a grid size of 2 or 3 makes too small a square for an array of hints
		// a size of 1 or less doesn't make a grid
		Integer gSize = gameSize;
		if (gSize < 4 || gSize > 10) {
			gSize = 4;
		}
		modelSize = gSize;
		solutionB = new GameBoard(gSize);
		userB = new GameBoard(gSize);
		rowHints = new ArrayList<ArrayList<Integer>>();
		columnHints = new ArrayList<ArrayList<Integer>>();
		generateSolution(gSize);	// Load solution grid
		generateTrueXY(gSize);	// Load hint grid
	}
	
	/**
	 * Sets a square on the user board.
	 * @param x
	 * @param y
	 * @param value
	 */
	public void setSquareUserBoard(Integer x, Integer y, char value) {
		userB.setSquare(x, y, value);
	}
	
	public char getSquareUserBoard(Integer x, Integer y) {
		return userB.getBoardValue(x, y);
	}
	
	public char getSquareSolBoard(Integer x, Integer y) {
		return solutionB.getBoardValue(x, y);
	}
	
	/**
	 * This returns a copy of either the column or row hints.
	 * @param cOrR - 0 for the column hints, anything else for row hints
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> getHints(Integer cOrR){
		//Given that trueX and trueY have been initialized, return the respective array
		if(cOrR == 0) {
			return columnHints;
		}else {
			return rowHints;
		}
	}
	
	/**
	 * Returns a copy of the solution grid.
	 * @return
	 */
	public GameBoard getSolution() {
		return solutionB;
	}
	
	/**
	 * Returns a copy of the user grid.
	 * @return
	 */
	public GameBoard getUserGrid() {
		return userB;
	}
	
	public Integer getModelSize() {
		return modelSize;
	}
	
	/**
	 * Checks and compares the solution to the current user board.
	 * @return - true if the user's board matches the solution, false otherwise.
	 */
	public boolean isCorrect() {

		for (int i = 0; i < solutionB.getSize(); i++){
		    for (int j = 0; j < solutionB.getSize(); j++){
		    	if(solutionB.getBoardValue(i, j) != userB.getBoardValue(i, j)){
			    return false;
			    }
		    }
		}

		return true;
	}
	
}

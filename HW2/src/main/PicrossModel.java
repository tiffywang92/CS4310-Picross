package main;

import java.util.ArrayList;

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
		
	}
	
	/**
	 * Generates the hints for solutionB and stores them in trueX and trueY.
	 */
	private void generateTrueXY() {
		
	}
	
	/**
	 * Constructor, initializes all values by generating a random play grid and corresponding hints.
	 * @param gameSize - the size to make the 2d square game board
	 */
	public PicrossModel(Integer gameSize) {
		
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
		return false;
	}
	
	

}

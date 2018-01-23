package main;

import java.util.Scanner;

/**
 * The Controller component manages user interactions (e.g., key presses,mouse clicks, etc.) and makes calls 
 * to the appropriate code in the View and the Model.
 *
 */
public class PicrossController {
	
	private PicrossModel picModel;
	private PicrossView picView;
	Scanner in;
	
	/**
	 * Initializes needed variables and then begins the main game loop logic.
	 * @param currentModel
	 * @param currentView
	 */
	public PicrossController(PicrossModel currentModel, PicrossView currentView) {
		picModel = currentModel;
		picView = currentView;
		
		mainGameLoop();
	}
	
	/**
	 * Main game loop, uses view to print out current user game board and the options.
	 */
	private void mainGameLoop() {
		
	}
	
	/**
	 * Takes in user input and if valid performs the correct function.
	 */
	private void takeOptionsInput() {
		
	}
	
	/**
	 * Takes in coordinates from the user and updates the model.
	 */
	private void takeAndSetCoordinates() {
		
	}

}

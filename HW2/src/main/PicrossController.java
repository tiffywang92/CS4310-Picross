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
	public PicrossController(PicrossModel currentModel, PicrossView currentView, Scanner in) {
		picModel = currentModel;
		picView = currentView;
		this.in = in;
		mainGameLoop();
	}
	
	/**
	 * Main game loop, uses view to print out current user game board and the options.
	 */
	private void mainGameLoop() {
		picView.displayText("Welcome to Picross");
		boolean endGame = false;
		while(!endGame) {
			picView.renderPlayBoard();
			picView.displayOptions();
			endGame = takeOptionsInput();
		}
		
		
	}
	
	/**
	 * Takes in user input and if valid performs the correct function.
	 */
	private boolean takeOptionsInput() {
		String temp;
		Integer uOption = -1;
		boolean corrInput = false;
		
		while(!corrInput) {
			temp = in.nextLine();
			try {
				uOption = Integer.parseInt(temp);
				corrInput = true;
			} catch (NumberFormatException exception){
				picView.displayText("Please enter a number\n");
				return false;
			}
		}
		
		switch(uOption) {
		case 1:
			if(picModel.isCorrect()) {
				picView.displayVictory();
				return true;
			}else {
				picView.displayIncorrect();
			}
			break;
		case 2:
			picView.displayInputData();
			takeAndSetCoordinates();
			break;
		case 3:
			return true;
		default:
			picView.displayText("Please enter a valid number");
		}
		
		return false;
	}
	
	/**
	 * Takes in coordinates from the user and updates the model.
	 */
	private void takeAndSetCoordinates() {
		
	}

}

package main;

import static PicrossModel.java;

/**
 * The View component defines and manages how the data is presented to the user.
 * Since this project is text and not GUI based, this will be a more passive view,
 * and will not take in user input.
 *
 */
public class PicrossView {
	private PicrossModel picModel;
	
	/**
	 * Constructor - initializes model based on imported file
	 */
	public PicrossView(PicrossModel currentModel) {
		picModel = currentModel;
	}
	
	/**
	 * Prints out the user board with hints to standard output.
	 */
	public void renderPlayBoard() {
		System.out.println();
		System.out.println("***Game Board***");

		//Print out column hints 
		for(int x = picModel.getUserGrid().getSize(); x > 0; x--) {
		    System.out.print((x+1) + ") ");
		    if(picModel.getHints(1)[x][1] == 0) {
			System.out.println(picModel.getHints(1)[x][0]);
		    }else {
			System.out.println(picModel.getHints(1)[x][0] + ", " + picModel.getHints(1)[x][1]);
		    }
		}
		System.out.println();
		System.out.print("  ");
		for(int x = 0; x < picModel.getUserGrid().getSize(); x++) {
		    System.out.print(" " + x + " ");
		}
		char[] letters = {'A', 'B', 'C', 'D'};

		//Print out the rest
		System.out.println();
		for(int x = 0; x < picModel.getUserGrid().getSize(); x++) {
		    System.out.print(letters[x] + " ");
		    for(int y = 0; y < picModel.getUserGrid().getSize(); y++) {
			System.out.print(" ");
			if(picModel.getUserGrid()[x][y]) {
			    System.out.print("0");
			} else {
			    System.out.print("-");
			}
			System.out.print(" ");
		    }
		    if(picModel.getHints(0)[x][1] == 0) {
			System.out.println("\t=> " + picModel.getHints(0)[x][0]);
		    }else {
			System.out.println("\t=> " + picModel.getHints(0)[x][0] + ", " + picModel.getHints(0)[x][1]);
		    }
		}
	}
	
	/**
	 * Prints out the solution board without hints to standard output.
	 */
	public void renderSolution() {
		System.out.println();
		System.out.println("***Solution***");
		System.out.print("  ");
		for(int x = 0; x < picModel.getUserGrid().getSize(); x++) {
		    System.out.print(" " + x + " ");
		}
		System.out.println();
		char[] letters = {'A', 'B', 'C', 'D'};
		for(int x = 0; x < picModel.getUserGrid().getSize(); x++) {
		    System.out.print(letters[x] + " ");
		    for(int y = 0; y < picModel.getUserGrid().getSize(); y++) {
			System.out.print(" ");
			if(picModel.getSolution()[x][y]) {
			    System.out.print("0");
			} else {
			    System.out.print("-");
			}
			System.out.print(" ");
		    }
		    System.out.println();
		}
	}
	
	/**
	 * Prints out the various options for the user.
	 * Check if correct, input data, give up
	 */
	public void displayOptions() {
		System.out.println("Menu");
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1. Check solution");
		System.out.println("2. Input grid coordinates");
		System.out.println("3. End game");
		System.out.println();
		System.out.print("Enter your choice: ");
		// Follow with getting user input
	}
	
	/**
	 * Prints out how to input coordinates.
	 */
	public void displayInputData() {
		System.out.println("Enter your answer with o or x; o as filled and x as not.");
		System.out.println("Separate by space, but leave out spaces at end of line for best results.");
	}

	/**
	 * Displays a victory message.
	 */
	public void displayVictory() {
		System.out.println("You win! Play again? (Press q to quit)");
	}
	
	/**
	 * Shames the player then displays the solution
	 */
	public void displayGiveUp() {
		// DISHONOR! Dishonor on you, dishonor on your family, dishonor on your cow...
		System.out.println("Sorry, you lose! Play again? (Press q to quit)");
	}
	
	/**
	 * Tells the player their guess was incorrect and encourages them to keep trying
	 */
	public void displayIncorrect() {
		System.out.println("Your solution is incorrect. Try again? (Press q to quit)");
	}
	
	/**
	 * For displaying miscellaneous text
	 */
	public void displayText(String toDisp) {
		System.out.println(toDisp);
	}
}

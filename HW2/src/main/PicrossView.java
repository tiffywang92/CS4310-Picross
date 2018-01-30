package main;


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
		int last = 0;
		for(int x = 0; x < picModel.getModelSize(); ++x) {
		    System.out.print((x) + ") ");
		    for(Integer toPrint : picModel.getHints(0).get(x)) {
//		    	if(last != picModel.getHints(0).get(x).size() - 1) {
//		    		System.out.print(toPrint + ", ");
//		    		++last;
//		    	} else {
//		    		System.out.println(toPrint);
//		    		last = 0;
//		    	}
		    	System.out.print(toPrint + ", ");
		    }
		    System.out.println();
		}
		
		System.out.println();
		System.out.print("  ");
		for(int x = 0; x < picModel.getUserGrid().getSize(); x++) {
		    System.out.print(" " + x + " ");
		}
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

		//Print out the rest
		System.out.println();
		for(int x = 0; x < picModel.getModelSize(); x++) {
		    System.out.print(letters[x] + " ");
		    for(int y = 0; y < picModel.getModelSize(); y++) {
		    	System.out.print(" ");
		    	if(picModel.getSquareUserBoard(x, y) == 'o') {
		    		System.out.print("o");
		    	} else {
		    		System.out.print("-");
		    	}
		    	System.out.print(" ");
		    }
		    System.out.print( "\t" + letters[x] + ") ");
		    for(Integer toPrint : picModel.getHints(1).get(x)) {
//		    	if(last != picModel.getHints(1).get(x).size() - 1) {
//		    		System.out.print(toPrint + ", ");
//		    		++last;
//		    	} else {
//		    		System.out.println(toPrint);
//		    		last = 0;
//		    	}
		    	System.out.print(toPrint + ", ");
		    }
		    System.out.println();
		    
		}
	}
	
	/**
	 * Prints out the solution board without hints to standard output.
	 */
	public void renderSolution() {
		System.out.println();
		System.out.println("***Solution***");
		System.out.print("  ");
		for(int x = 0; x < picModel.getModelSize(); x++) {
		    System.out.print(" " + x + " ");
		}
		System.out.println();
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		for(int x = 0; x < picModel.getModelSize(); x++) {
		    System.out.print(letters[x] + " ");
		    for(int y = 0; y < picModel.getModelSize(); y++) {
		    	System.out.print(" ");
		    	if(picModel.getSquareSolBoard(x, y) == 'o') {
		    		System.out.print("o");
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
		System.out.println("\n***Menu***");
		System.out.println("What would you like to do?");
		System.out.println("1. Check your answer");
		System.out.println("2. Input grid coordinates");
		System.out.println("3. Give up");
		System.out.println("4. Quit");
		System.out.print("Enter your choice: ");
	}
	
	/**
	 * Prints out how to input coordinates.
	 */
	public void displayInputData() {
		System.out.println("\nTo enter coordinates please write the row letter followed directly after by the column number. Example : A1");
		System.out.print("Coordinates : ");
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
		renderSolution();
		System.out.println("Sorry, you lose!");
	}
	
	/**
	 * Tells the player their guess was incorrect and encourages them to keep trying
	 */
	public void displayIncorrect() {
		System.out.println("\nYour solution is incorrect, but you are getting close.");
	}
	
	/**
	 * For displaying miscellaneous text
	 */
	public void displayText(String toDisp) {
		System.out.println(toDisp);
	}
}

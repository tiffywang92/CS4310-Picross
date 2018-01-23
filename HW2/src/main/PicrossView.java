package main;

/**
 * The View component defines and manages how the data is presented to the user.
 * Since this project is text and not GUI based, this will be a more passive view,
 * and will not take in user input.
 *
 */
public class PicrossView {
	private PicrossModel picModel;
	
	
	public PicrossView(PicrossModel currentModel) {
		picModel = currentModel;
	}
	
	/**
	 * Prints out the user board with hints to standard output.
	 */
	public void renderPlayBoard() {
		
	}
	
	/**
	 * Prints out the solution board without hints to standard output.
	 */
	public void renderSolution() {
		
	}
	
	/**
	 * Prints out the various options for the user.
	 * Check if correct, input data, give up
	 */
	public void displayOptions() {
		
	}
	
	/**
	 * Prints out how to input coordinates.
	 */
	public void displayInputData() {
		
	}

	/**
	 * Displays a victory message.
	 */
	public void displayVictory() {
		
	}
	
	/**
	 * Shames the player then displays the solution
	 */
	public void displayGiveUp() {
		
	}
	
	/**
	 * Tells the player their guess was incorrect and encourages them to keep trying
	 */
	public void displayIncorrect() {
		
	}
	
	public void displayText(String toDisp) {
		System.out.println(toDisp);
	}
}

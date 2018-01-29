package main;
import java.util.Scanner;

/**
 * The Controller component manages user interactions (e.g., key presses,mouse clicks, etc.) and makes calls 
 * to the appropriate code in the View and the Model.
 *
 */
public class Conn4Controller {
	
	private Conn4Model conModel;
	private Conn4View conView;
	Scanner read = new Scanner(System.in);
	String input = "";
	
	/**
	 * Initializes needed variables and then begins the main game loop logic.
	 * @param currentModel
	 * @param currentView
	 */
	public Conn4Controller(Conn4Model currentModel, Conn4View currentView) {
		conModel = currentModel;
		conView = currentView;
		mainGameLoop();
	}
	
	/**
	 * Main game loop, uses view to print out current user game board and the options.
	 */
	private void mainGameLoop() {
		char turn = ' ';
		int k = 1;
		boolean repeat = true;
		do  {
			if ( (k%2) ==1) turn = 'X';
			else turn = 'O';
				conView.printBoard();
				conView.printPrompt(turn);
				getInput();
				if (getY() == -16) {
					repeat = false;
					break;
				}
				else if (!conModel.setSquare(getX(), getY(), turn)) {
					System.out.println("Invalid Entry, try again: ");
					repeat =true;
					k--;
					}
				if (conModel.checkSolution(conModel.getSize())) {
					System.out.println();
					System.out.println(turn + " WINS!");
					repeat = false;
					conView.printBoard();
				}
			k++;
		} while (repeat == true);	
		System.out.println("Game Ended.");
	}
	
	
	
	/**
	 * Takes in coordinates from the user and updates the model.
	 */
	//read in user input
	public void getInput() {
		input  = read.nextLine();
	}
	
	//extract y coordinate
	public int getY () {
		try {
			return input.charAt(0)-97;
		} catch (IndexOutOfBoundsException e) {
		    return -1;
		} 
	}
	
	//extract x coordinate
	public int getX () {
		try {
			return input.charAt(1)-49;
		} catch (IndexOutOfBoundsException e) {
				return -1;
		}
	}
}

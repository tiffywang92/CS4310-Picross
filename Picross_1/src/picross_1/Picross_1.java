/*
 * Project 1: Picross Puzzle
 */
package picross_1;
import java.util.Random;
import java.io.*;
import static picross_1.Picross_1.createSol;

/*
 * Check the members.txt file in the docs folder for member info
 */
public class Picross_1 {

    static boolean [][]solGrid = new boolean[4][4];
    static boolean[][] userGrid = new boolean[4][4];
    static int [][] trueX  = new int [4][2];
    static int [][] trueY = new int [4][2];

    /*Create and initialize the solution grid randomly, also calculate the random grid hint and store in trueX and trueY*/
    /* Author Sai Tam */
    public static void createSol() {
    	
	// Create randomnized grid
    	Random r = new Random(); 
    	for (int y = 0 ; y < 4 ; y++)
    		for ( int x = 0 ; x < 4 ; x++) 
    			solGrid[x][y] = r.nextBoolean();
	    
	
	//  Reset User Grid
    	for (int y = 0 ; y < 4 ; y++)
    		for ( int x = 0 ; x < 4 ; x++) 
    			userGrid[x][y] = false;   
	    
	// Reset hint grid to 0
	for (int y = 0 ; y < 4 ; y++)
    		for ( int x = 0 ; x < 2 ; x++) {
    			trueX[y][x] = 0;
    			trueY[y][x] = 0;
    		}
    	
    	//Compute x-axis hint
    	int tempCount = 0;
    	for (int y = 0 ; y < 4 ; y++) {
            for ( int x = 0 ; x < 4 ; x++) {
                if (solGrid[y][x] == true)
                    trueX[y][tempCount] ++;		//Found box true, up the hint count
                else if (trueX[y][0] !=0 && solGrid[y][x] == false)
                tempCount  = 1; 	// Found box false and previous is not true, move to 2nd element
                else;  //box false, do nothing
            }
            tempCount = 0;   
    	}	
    	
    	tempCount = 0;  //reset count for picking up y-axis hint
    	
    	//Compute y-axis hint
    	for ( int x = 0 ; x < 4 ; x++) {
            for (int y = 0 ; y < 4 ; y++) {
                if (solGrid[y][x] == true)
                    trueY[x][tempCount] ++;		//Found box true, up the hint count
    		else if (trueY[x][0] !=0 && solGrid[y][x] == false)
                    tempCount  = 1; 	// Found box false and previous is not true, move to 2nd element
    		else;	//box false, do nothing
            }
            tempCount = 0;
    	}	
    }

    /**
     * Prints out the solution board without hints to standard output.
     * -Anthony S.
     */
    static void drawSolutionBoard() {
        System.out.println();
	System.out.println("***Solution***");
	System.out.print("  ");
	for(int x = 1; x < 5; x++) {
            System.out.print(" " + x + " ");
	}
	System.out.println();
	char[] letters = {'A', 'B', 'C', 'D'};
	for(int x = 0; x < 4; x++) {
            System.out.print(letters[x] + " ");
            for(int y = 0; y < 4; y++) {
		System.out.print(" ");
		if(solGrid[x][y]) {
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
     * Prints out the user board with hints to standard output.
     * -Anthony S.
     */
    static void drawUserBoard() {
	System.out.println();
	System.out.println("***Game Board***");

	//Print out column hints 
	for(int x = 3; x > -1; x--) {
            System.out.print((x+1) + ") ");
            if(trueY[x][1] == 0) {
		System.out.println(trueY[x][0]);
            }else {
		System.out.println(trueY[x][0] + ", " + trueY[x][1]);
            }
	}
	System.out.println();
	System.out.print("  ");
	for(int x = 1; x < 5; x++) {
            System.out.print(" " + x + " ");
	}
	char[] letters = {'A', 'B', 'C', 'D'};

	//Print out the rest
	System.out.println();
	for(int x = 0; x < 4; x++) {
            System.out.print(letters[x] + " ");
            for(int y = 0; y < 4; y++) {
		System.out.print(" ");
		if(userGrid[x][y]) {
                    System.out.print("0");
		} else {
                    System.out.print("-");
		}
		System.out.print(" ");
            }
            if(trueX[x][1] == 0) {
		System.out.println("\t=> " + trueX[x][0]);
            }else {
		System.out.println("\t=> " + trueX[x][0] + ", " + trueX[x][1]);
            }
	}	
    }

    /* Checks user input filled into userGrid with solGrid & returns result */
    public static boolean scoring(boolean[][]solGrid, boolean[][]userGrid){
        boolean correct = true;  //correct flag

        for (int i = 0; i<solGrid.length; i++){
            for (int j = 0; j<solGrid[i].length; j++){
                if(solGrid[i][j] != userGrid[i][j]){
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
    }

    /* Driver program: sets game to loop with new games each try */
    public static void main(String[] args) throws IOException {
        InputStreamReader cin = new InputStreamReader(System.in);
	boolean valid; // depends on scoring
	char repeat = ' '; // holds user choice to restart game
        int num = 1; // counter for games
        char item; // holds user input to fill board
	
    	try {
            while (repeat != 'q') {
                createSol();
                System.out.println("Game #" + num++);
                drawUserBoard();
                System.out.println();
                System.out.println("Enter your answer with o or x; o as filled and x as not.");
		System.out.println("Separate by space, but leave out spaces at end of line.");
                for (int i = 0; i < 4; i++) {
                    System.out.print("Row " + (i+1) + ": ");
                    for (int j = 0; j < 4; j++) {
                        item = (char) cin.read();
                        cin.read();
                        if (item == 'o')
                            userGrid[i][j] = true;
                    }
                }
                System.out.println();
                valid = scoring(solGrid, userGrid);
                if (!valid) // if not correct
                    drawSolutionBoard();
                System.out.println();
                System.out.println("Play again? (Press q to quit)");
                repeat = (char) cin.read();
                System.out.println();
            }
        } finally {
            cin.close();
        }
    }
}

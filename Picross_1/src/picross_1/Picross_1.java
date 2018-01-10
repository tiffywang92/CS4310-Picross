/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picross_1;
import java.util.Random;



/**
 *
 * @author Tiffany
 */
public class Picross_1 {

    static boolean [][]solGrid = new boolean[4][4];
    static boolean[][] userGrid = new boolean[4][4];
    static int [][] trueX  = new int [4][2];
    static int [][] trueY = new int [4][2];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//grid first = new grid();
    	//first.setGrid(createGrid());
    	createSol();
    	drawGrid();
    	
        //userGrid[0][1]= 1;
        //createGrid (pcGrid);
        //drawGrid(pcGrid);
        System.out.println("Sample");   
    }


	/*Create and initialize the solution grid randomly, also calculate the random grid hint and store in trueX and trueY*/
    public static void createSol() {
    	
    	Random r = new Random(); 
    	for (int y = 0 ; y < 4 ; y++)
    		for ( int x = 0 ; x < 4 ; x++) 
    			solGrid[x][y] = r.nextBoolean();
    	
    	//Compute x-axis hint
    	int tempCount = 0;
    	for (int y = 0 ; y < 4 ; y++) {
    		for ( int x = 0 ; x < 4 ; x++) {
    			if (solGrid[y][x] == true)
    				trueX[y][tempCount] ++;		//Found box true, up the hint count
    			else if (trueX[y][0] !=0 && solGrid[y][x] == false)
    				tempCount  = 1; 	// Found box false and previous is not true, move to 2nd element
    			else 
    				tempCount = tempCount;  //box false, do nothing
    		}
    	tempCount = 0;   
    	}	
    	
    	tempCount = 0;  //reset count for picking up y axis hint
    	
    	//Compute x-axis hint
    	for ( int x = 0 ; x < 4 ; x++) {
    		for (int y = 0 ; y < 4 ; y++) {
    			if (solGrid[y][x] == true)
    				trueY[x][tempCount] ++;		//Found box true, up the hint count
    			else if (trueY[x][0] !=0 && solGrid[y][x] == false)
    				tempCount  = 1; 	// Found box false and previous is not true, move to 2nd element
    			else 
    				tempCount = tempCount;	//box false, do nothing
    		}
    	tempCount = 0;
    	}	
    }
    
 
    /* drawGrid: prints out solution grid */
}

/** Insert another method here to generate user grid + number clues
*   And maybe another to print it all out
* 
*   - Tiffany
*/

/**
	 * Prints out the solution board without hints to standard output.
	 * -Anthony S.
	 */
	static void drawSolutionBoard() {
		System.out.println();
		System.out.println("***Solution***");
		for(int x = 0; x < 4; x++) {
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
		for(int x = 1; x < 5; x++) {
			System.out.print(" " + x + " ");
		}
		
		//Print out the rest
		System.out.println();
		for(int x = 0; x < 4; x++) {
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


}

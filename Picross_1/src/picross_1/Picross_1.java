/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picross_1;

/**
 *
 * @author Tiffany
 */
public class Picross_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sample Puzzle\n");
        int[][] userGrid = new int[4][4];   // to do: print out blank grid
        int [][] pcGrid = new int [4][4];   // to match with solution
        createGrid (pcGrid);
        drawGrid(pcGrid);
    }

    /* createGrid: generates solution grid */
    public static int [][] createGrid(int [][] grid) {
        Random r = new Random(); 
        for (int y = 0 ; y < 4 ; y++)
            for ( int x = 0 ; x < 4 ; x++)
                if (r.nextBoolean())
                    grid[x][y] = 1;
        return grid;
    }
 
    /* drawGrid: prints out solution grid */
    public static void drawGrid(int grid[][]) {
        for (int i = 0; i <4; i++) {
            System.out.print(' ');
            System.out.print('_');
        }
        System.out.println(' ');
        for (int y = 0; y < 4; y ++) {
            for (int x = 0; x <4; x++) {
                System.out.print('|');
                if (grid[x][y] == 1)
                    System.out.print('O');
                else
                    System.out.print('_');
            }
        System.out.println('|');
        }
    }
}

/** Insert another method here to generate user grid + number clues
*   And maybe another to print it all out
* 
*   - Tiffany
*/
}

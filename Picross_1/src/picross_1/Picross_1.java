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
        int[][] grid = new int[4][4];
        grid[0][0]= 1;
        drawGrid(grid);
        System.out.println("Sample");
    }

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

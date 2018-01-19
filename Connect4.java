
package connect4;
import java.util.Random;
import java.io.*;

/**
 * See members.txt in the docs folder
 */
public class Connect4 {
    
    // global variables
    static boolean[][] userGrid = new boolean[4][4];
    
    /*
     * Add methods here
     */

    /* Driver program: sets which game to play & loops until user quits */
    public static void main(String[] args) throws IOException {
        InputStreamReader cin = new InputStreamReader(System.in);
	boolean valid; // depends on scoring
	char repeat = ' '; // holds user choice to restart game
        int num = 1; // counter for games
        char item; // holds user input to fill board
        
        try {
            while (repeat != 'q') {
                // TODO: first decide how to get a workable AI
                // In the meantime, work on 2-player version
            }
        } finally {
            cin.close();
        }
    }
    
}

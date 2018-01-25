package main;



/**
 * The Model component manages the system data and associated operations on that data.
 * This will be a passive model that has it's data "pulled" by the view and controller,
 * rather than an active one that can "push" updates to the controller and view.
 *
 */
public class Conn4Model {
	
	private GameBoard userB;

	
	/**
	 * Check the board to see if there's any winning line
	 *
	 */
	
	public Boolean checkSolution(int gameSize) {
		int winFlag = 0;
		int i, j;
		
		// Checking forward sloping solution 
		for (i = 0;  i < gameSize -1 ; i++)
			if (userB.getBoardValue(i,i) == userB.getBoardValue(i+1,i+1)) 
				winFlag ++;
		if (winFlag == gameSize -1)
			return true;
		
		winFlag = 0;
		
		// Checking backward sloping solution 
		for (i = gameSize - 1 ;  i >= 0 ; i--)
			for (j = 0; j < gameSize -1 ; j++) {
				if (userB.getBoardValue(i,j) == userB.getBoardValue(i-1,j+1)) 
				winFlag ++;
			}
		if (winFlag == gameSize -1)
			return true;
		
		winFlag = 0;
		
		
		//checking horizontal solution
		for (i = 0; i < gameSize; i++) {
			for (j = 0; j < gameSize -1 ; j++) {
				if (userB.getBoardValue(i,j) == userB.getBoardValue(i,j+1)) {
					winFlag ++;
					if (winFlag == gameSize -1)
						return true;
				}
			}
			winFlag = 0;
		}
			
		
		winFlag = 0;
		
		//checking vertical solution
		for (j = 0; j < gameSize  ; j++) {
			for (i = 0; i < gameSize-1; i++) {
				if (userB.getBoardValue(i,j)  == userB.getBoardValue(i+1,j)) {
					winFlag ++;
					if (winFlag == gameSize -1)
						return true;
				}
			}
			winFlag = 0;
		}
		
		return false;
	}
	

	
	/**
	 * Constructor, initializes the board with fake value, so that when checksolution is called they are all unique value
	 */
	public Conn4Model(Integer gameSize) {
		userB = new GameBoard(gameSize);
		char fakeSquares = 'a';
	    for (int i = 0; i < gameSize; i++)
	    	for (int j = 0; j < gameSize; j++) {
	    		userB.setSquare(i, j, fakeSquares);   
	    		fakeSquares ++;
	    	}
	}

	
	
	
	
	/**
	 * Sets a square on the user board.
	 * @param x
	 * @param y
	 * @param value
	 */
	public boolean setSquare(Integer x, Integer y, char value) {
		if (userB.getBoardValue(x, y) == 'X' || userB.getBoardValue(x, y) == 'O' || x >= getSize() || y >= getSize() || x < 0 || y< 0) //Validating input
			return false;
		userB.setSquare(x, y, value);
		return true;
	}
	
	public char getSquare(Integer x, Integer y) {
		return userB.getBoardValue(x, y);
	}
	
	//Get boardSize
	public int getSize() {
		return userB.getSize();
	}
	
	
	



	
	

}

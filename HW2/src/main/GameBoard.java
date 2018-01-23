package main;

public class GameBoard {
	
	private int[][] gBoard;
	private int size;
	
	
	public void GameBoard(int size) {
		gBoard = new int[size][size];
		this.size = size;
	}
	
	public Integer getBoardValue(int x, int y) {
		if(x < size && x >= 0) {
			if(y < size && y >= 0) {
				return gBoard[x][y];
			}
		}
		return -1;
	}
	
	public void setSquare(int x, int y, int value) {
		if(x < size && x >= 0) {
			if(y < size && y >= 0) {
				gBoard[x][y] = value;
			}
		}
	}

}

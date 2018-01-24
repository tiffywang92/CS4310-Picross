package main;

public class GameBoard {
	
	private char[][] gBoard;
	private int size;
	
	
	public void GameBoard(int size) {
		gBoard = new char[size][size];
		this.size = size;
	}
	
	public char getBoardValue(int x, int y) {
		if(x < size && x >= 0) {
			if(y < size && y >= 0) {
				return gBoard[x][y];
			}
		}
		return ' ';
	}
	
	public void setSquare(int x, int y, char value) {
		if(x < size && x >= 0) {
			if(y < size && y >= 0) {
				gBoard[x][y] = value;
			}
		}
	}

}

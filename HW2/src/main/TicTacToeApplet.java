import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
/*
   Applet version of the Earlier commane-line application. Uses the same Board object as
   a member variable of the Applet.
*/
public class TicTacToeApplet 
    extends Applet implements ActionListener,Runnable {
  SquareButton[] buttons = new SquareButton[26];
  Board board;
  Panel boardPanel = new Panel(); 
  Panel controlPanel = new Panel();
  Button autoButton = new Button("AUTOPLAY");  // to initiate autoplay

  //.
  boolean gameOver;
  public void init() {
	  this.setLayout(new BorderLayout());
	  this.add(boardPanel,BorderLayout.CENTER);
	  this.add(controlPanel,BorderLayout.NORTH);
	  controlPanel.add(autoButton);
	  autoButton.addActionListener(this);
    boardPanel.setLayout(new GridLayout(5, 5, 1, 1));
    for (int i = 1; i <= 25; i++) {
      (buttons[i] = new SquareButton(i)).addActionListener(this);
      boardPanel.add(buttons[i]);
    }
    startGame();
  }

  public void startGame() {
    gameOver = false;
    board = new Board();
    SquareButton.clearLast();
    board.randomStart();
    drawBoard();
    
  }
  public void run() {
	  boolean gameOver = false;
	  drawBoard();
	  do {
		  try {
			  Thread.sleep(1000);
		  }
		  catch (InterruptedException e) {}
		  gameOver = move(board.bestMove(0).square,false);  // computer move
		  drawBoard();
		 
	  }
	  while (!gameOver);
  }
  public void auto() {
	  Thread runner = new Thread(this);
	  runner.start();
  }

  public void endGame(boolean computerWin, boolean humanWin) {
    gameOver = true;
    String message =
        (computerWin ? "I Win." : (humanWin ? "Yow Win." : "Tie Game.")) +
        " Play again?";
    if (JOptionPane.showOptionDialog(null, message, "",
                                     JOptionPane.YES_NO_OPTION, 0, null, null, null)
        == JOptionPane.YES_OPTION)
      startGame();
  }

  public void drawBoard() {
    for (int i = 1; i < 26; i++)
      buttons[i].setLabel(Character.toString(board.squares[i]));
  }

  public void actionPerformed(ActionEvent e) {
	if (e.getSource() == autoButton) {auto(); return;}
    int squareNum = ( (SquareButton) e.getSource()).id;
    if (!board.isFreeSquare(squareNum) || gameOver) return; // can't move here
    if (move(squareNum,true)) return ; // human move
    try {Thread.sleep(500);} catch (InterruptedException e1) {} // a slight pause
    move(board.bestMove(0).square,false);  // computer move
  }

// Make the move.
// If the game is determined to be over then call endGame() and return true.
// Otherwise return false.
boolean move(int squareNum, boolean humanMove) {
  board.moveToSquare(squareNum); // human move
  this.drawBoard();
  if (board.boardValue() != 0) /* someone won */ {
    endGame(!humanMove, humanMove);
    return true;  // game over
  }
  if (board.boardFull())  /* tie game */ {
    endGame(false, false);
    return true;  // game over
  }
  return false;  // game continues
}


}
// Provides a colored button to represent one of the the nine squares.
class SquareButton extends Button implements ActionListener {
    private static SquareButton lastClicked = null;
    private static final Color defaultColor = new Color(80,180,255), clickedColor = new Color(80,230,220);
    int id;
    public SquareButton(int id) {
      super();
      this.id = id;
      this.setFont(new Font("Courier",Font.BOLD,54));
      this.setBackground(defaultColor);
      this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
      String s = e.getActionCommand();
       if (s.equals("X") || s.equals("O")) return;
       clearLast();
       setLast(this);
    }
    public static void clearLast() {
      if (lastClicked != null) {
        lastClicked.setBackground(defaultColor);
        lastClicked = null;
      }
    }
    public static void setLast(SquareButton b) {
      b.setBackground(clickedColor);
      lastClicked = b;
    }
  }
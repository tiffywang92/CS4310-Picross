package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		gameStartUp();
		
	}
	
	static void gameStartUp() {
		char answer;
		boolean quitGame = false;
		String temp;
		Scanner in = new Scanner(System.in);
		
		while(!quitGame) {
			System.out.println("\nPicross = 1, Connect Four = 2, Quit = 3");
			System.out.print("What would you like to do:  ");
			temp = in.nextLine();
			answer = temp.charAt(0);
			
			switch(answer) {
			case '1':
				runPicross();
				break;
			case '2':
				runConn4();
				break;
			case '3':
				quitGame = true;
				System.out.println("Thanks for playing");
				break;
			default:
				System.out.println("Please enter one of the numbers displayed.\n");
			}
		}
	}
	
	static void runPicross() {
		//PicrossModel picModel = new PicrossModel(howLarge());
		//PicrossView picView = new PicrossView(picModel);
		//PicrossController picCon = new PicrossController(picModel, picView);
	}
	
	static void runConn4() {
		Conn4Model conModel = new Conn4Model(howLarge());
		Conn4View conView = new Conn4View(conModel);
		Conn4Controller conCon = new Conn4Controller(conModel, conView);
	}
	
	static int howLarge() {
		String temp;
		int toReturn = 0;
		boolean corrInput = false;
		Scanner in = new Scanner(System.in);
		
		while(!corrInput) {
			System.out.print("How large should grid be:  ");
			temp = in.nextLine();
			try {
				toReturn = Integer.parseInt(temp);
				corrInput = true;
			} catch (NumberFormatException exception){
				System.out.println("Please enter a number");
			}
			
		}
		System.out.println("\n");
		return toReturn;
		
	}

}

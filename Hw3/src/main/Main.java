package main;

import java.util.Scanner;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {

		runApp();

	}
	
	static void runApp() {
		Scanner in = new Scanner(System.in);
		RemindersModel newModel = new RemindersModel();
		RemindersView newView = new RemindersView(newModel, in);
		RemindersController newController = new RemindersController(newModel, newView);
		in.close();
	}

}

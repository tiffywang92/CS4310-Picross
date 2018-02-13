package main;

import java.util.Scanner;

/**
 * The View component defines and manages how the data is presented to the user.
 * This project will contain an active view which takes in user input and
 * returns it to the controller.
 *
 */
public class RemindersView {
	
	private RemindersModel remModel;
	private Scanner in;

	RemindersView(RemindersModel newModel, Scanner input){
		remModel = newModel;
		in = input;
	}
	
	/**
	 * Has the user input correct data for appointment creation
	 * @return - appointment containing the inputed data
	 */
	public Appointment createAppointment() {
		Integer year, month, day, hour, minute;
		String title, description;
		//question user and store answers in variables
		Appointment newAppoint = new Appointment(year, month, day, hour, minute, title, description);
		return newAppoint;
	}
	
	/**
	 * Displays options and takes in input, returns an integer corresponding to the option below
	 * 1) create new Appointment
	 * 2) Scroll through appointment
	 * 3) quit
	 * Extra to implement if time Find, Load/Save
	 * @return - the number corresponding to the user choice
	 */
	public Integer mainMenu() {
		return null;
	}
	
	/**
	 * Displays Appointment ID, then the Appointment information, then the menu choices below
	 * 1) forward
	 * 2) back
	 * 3) delete
	 * 4) Implement if time - editing
	 * @param toDisp - the index of appointment to display
	 * @return - the number corresponding to the user choice
	 */
	public Integer scrollMenu(Integer toDisp) {
		return null;
		
	}
	
	/**
	 * Display string "Due Now" or something, then the Appointment information
	 * Can do in pop up using JOptionPane.showMessageDialog(null, "string");
	 * If no pop up use an input break (ask for enter press) to pause controllers app loop
	 * @param toDisp - the index of Appointment to display
	 */
	public void displayAppointmentDue(Integer toDisp) {
		
	}
}

package main;

import java.util.Scanner;

import javax.swing.JOptionPane;

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
		char save = 'n';
		int year, month, day, hour, minute, reminder = 0;
		String title, description;
		Appointment newAppoint;
		do {
			Scanner sc = new Scanner (System.in);
			System.out.print ("Please enter Title of your Appt : ");
			title = sc.nextLine();
			System.out.print ("Please enter description of your Appt : ");
			description = sc.nextLine();
			System.out.print ("Please enter the month of your Appt: ");
			month = sc.nextInt();
			System.out.print ("Please enter the day of your Appt: ");
			day = sc.nextInt();
			System.out.print ("Please enter the year of your Appt: ");
			year = sc.nextInt();
			System.out.print ("Please enter the hour of your Appt: ");
			hour = sc.nextInt();
			System.out.print ("Please enter the minute of your Appt: ");
			minute = sc.nextInt();
			System.out.print ("Please enter the Reminder Alarm in minute: ");
			reminder = sc.nextInt();
			System.out.println();
			System.out.println("Please confirm the Appt Below ");
			newAppoint = new Appointment(year, month, day, hour, minute, reminder, title, description);
			displayAppointment(newAppoint);
			System.out.println();
			System.out.println("Save ? (y/n)");
			save = sc.nextLine().charAt(0);
		}while (save !='y');		
		return newAppoint;
	}
	
	/**
	 * Displays options and takes in input, returns an integer corresponding to the option below
	 * @return - the number corresponding to the user choice
	 */
	public Integer mainMenu() {
		int input = 0;
		do {
			System.out.println ();
			System.out.println ("1) create new Appointment");
			System.out.println ("2) Scroll through appointment");
			System.out.println ("3) quit");
			System.out.print ("Please choose an options (1-3): ");
			System.out.println();
			try{
				Scanner sc = new Scanner (System.in);
				input = sc.nextInt();
				if (input != 1 && input !=2 && input !=3 ) { 
					System.out.println ("Invalid input, please enter 1, 2 or 3");	
				}
			}
			catch(Exception e) {
					System.out.println ("Invalid input, please enter 1, 2 or 3");	
				}
			System.out.println ();
		}while (input != 1 && input !=2 && input !=3 );
	return input;
	}
	
	/**
	 * Displays Appointment ID, then the Appointment information, then the menu choices below
	 * @param toDisp - the index of appointment to display
	 * @return - the number corresponding to the user choice
	 */
	
	public Integer scrollMenu(Integer toDisp) {
		System.out.println ("Appt ID: " + toDisp);
		displayAppointment(remModel.getAppointment(toDisp));
		int input = 0;
		do {
			System.out.println ();
			System.out.println ("1) forward");
			System.out.println ("2) back");
			System.out.println ("3) delete");
			System.out.print ("Please choose an options (1-3): ");
			System.out.println();
			try{
				Scanner sc = new Scanner (System.in);
				input = sc.nextInt();
				if (input != 1 && input !=2 && input !=3 ) { 
					System.out.println ("Invalid input, please enter 1, 2 or 3");	
				}
			}
			catch(Exception e) {
					System.out.println ("Invalid input, please enter 1, 2 or 3");	
				}
			System.out.println ();
		}while (input != 1 && input !=2 && input !=3 );
	return input;		
	}
	

	
	/**
	 * Display string "Due Now" or something, then the Appointment information
	 * Can do in pop up using JOptionPane.showMessageDialog(null, "string");
	 * If no pop up use an input break (ask for enter press) to pause controllers app loop
	 * @param toDisp - the index of Appointment to display
	 */
	public void displayAppointmentDue(Integer toDisp) {
		JOptionPane.showMessageDialog(null, remModel.getAppointment(toDisp).getTitle() + " is DUE! \n" );
	}
	
	/**
	 * Display appointment info 
	 * 
	 */
	public void displayAppointment (Appointment appt) {
		System.out.println("Subject : " + appt.getTitle());
		System.out.println("Description : "+ appt.getDescription());
		System.out.println("Date / Time : "+ appt.getMonth() + "/" + appt.getDay() +"/" + appt.getYear() + "  " + appt.getHour() + ":" + appt.getMinute());
		System.out.println("Reminder Alarm : " +appt.getReminder());
	}
}

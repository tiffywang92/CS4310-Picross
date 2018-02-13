package main;

/**
 * The Controller component will run the app loop and take in the input received from the view.
 * It will make calls to the appropriate code in the View and the Model based off the input.
 *
 */
public class RemindersController {
	
	private RemindersModel remModel;
	private RemindersView remView;
	
	RemindersController(RemindersModel remModel, RemindersView remView){
		this.remModel = remModel;
		this.remView = remView;
		appLoop();
	}
	
	private void appLoop() {
		Appointment temp;
		while(true) {
			temp = remModel.dueNow();
			if(temp != null) {
				//display it with view.displayAppointmentDue, then remove it (remove index 0)
			}else {
				//run main menu
			}
		}
	}
	
	/**
	 * Calls view's menu display, takes the integer returned from it and runs appropriate
	 * method/code
	 * Extra to implement if time Find, Load/Save
	 */
	private void runMainMenu() {
		
	}
	
	/**
	 * Calls view's scroll menu, takes the integer returned from it and runs appropriate
	 * code. Should start off at 0, use model.getSize to help with wrap around of scrolling
	 * make sure to update size for delete command, only need to implement edit if time - can
	 * be done by making a new appointment and deleting old one
	 */
	private void runScrollMenu() {
		Integer scrollPosition = 0;
		Integer size = remModel.getSize();
		if(size != 0) {
			//loop goes in here
		}
		
	}
	
	/**
	 * Exits the program, no need to go back to main with current Reminders implementation,
	 * if time to implement load/save may want to save here
	 */
	private void quitApp() {
		System.exit(0);
	}
	
	

}

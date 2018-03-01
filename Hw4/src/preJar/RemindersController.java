package preJar;

import java.util.Scanner;

public class RemindersController {
	
	private RemindersModel remModel;
	private RemindersView remView;
	
	
	RemindersController(){
		RemindersModel newModel = new RemindersModel();
		remModel = newModel;
	}
	
	public void addReminder(Appointment newAppoint) {
		
	}
	
	public boolean checkIfTimeUp() {
		return false;
	}
	
	
	
	
	//*****************************************************************************************
//	
//	RemindersController(RemindersModel remModel, RemindersView remView){
//		this.remModel = remModel;
//		this.remView = remView;
//		appLoop();
//	}
//	
//	private void appLoop() {
//		Appointment temp;
//		while(true) {
//			temp = remModel.dueNow();
//			if(temp != null) {
//				remView.displayAppointmentDue(0);
//				remModel.removeAppointment(0);
//			}else {
//				//run main menu
//				runMainMenu();
//			}
//		}
//	}
//	
//	/**
//	 * Calls view's menu display, takes the integer returned from it and runs appropriate
//	 * method/code
//	 * Extra to implement if time Find, Load/Save
//	 */
//	private void runMainMenu() {
//	       int temp = 0; 
//	       
//	       temp = remView.mainMenu(); 
//	       switch (temp) { 
//	           
//	           case 1: 
//	        	   remModel.addAppointment(remView.createAppointment());
//	        	   break;
//	           case 2: 
//	        	   runScrollMenu();
//	        	   break;
//	           case 3:  
//	        	   quitApp();
//	        	   break;
//	          default:  
//	        	  runMainMenu();
//	        	  break;
//	       }
//		
//	}
//	
//	/**
//	 * Calls view's scroll menu, takes the integer returned from it and runs appropriate
//	 * code. Should start off at 0, use model.getSize to help with wrap around of scrolling
//	 * make sure to update size for delete command, only need to implement edit if time - can
//	 * be done by making a new appointment and deleting old one
//	 */
//	private void runScrollMenu() {
//		Integer scrollPosition = 0;
//		Integer size = remModel.getSize();
//		int temp = 0;
//		while(size != 0) {
//			temp = remView.scrollMenu(scrollPosition);
//			
//			switch (temp){
//			    case 1: 
//			    	scrollPosition += 1;
//			    	if(scrollPosition == size) {
//			    		scrollPosition = 0;
//			    	}
//			    	break;
//			    case 2:
//			    	--scrollPosition;
//			    	if(scrollPosition == -1) {
//			    		scrollPosition = size - 1;
//			    	}
//			    	break;
//			    case 3: 
//			    	remModel.removeAppointment(scrollPosition);
//			    	size = remModel.getSize();
//			    	if(scrollPosition == size) {
//			    		--scrollPosition;
//			    	}
//			    	break;
//			    case 4:
//			    	size = 0;
//			    	break;
//			}
//		}
//		
//	}
//	
//	/**
//	 * Exits the program, no need to go back to main with current Reminders implementation,
//	 * if time to implement load/save may want to save here
//	 */
//	private void quitApp() {
//		System.exit(0);
//	}
//	
//	

}

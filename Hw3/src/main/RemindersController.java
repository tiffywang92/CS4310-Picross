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
				System.out.println(" This event is coming up" + remView.displayAppointmentDue());
				remModel.removeAppointment(0);
			}else {
				//run main menu
				runMainMenu();
			}
		}
	}
	
	/**
	 * Calls view's menu display, takes the integer returned from it and runs appropriate
	 * method/code
	 * Extra to implement if time Find, Load/Save
	 */
	private void runMainMenu() {
	       int temp = 0; 
	       
	       temp = remView.mainMenu(); 
	       switch (temp) { 
	           
	           case 1: remModel.addAppointment(remView.createAppointment());
	                    
	                    break;
	           case 2: runScrollMenu();
	                    break;
	           case 3:  quitApp();
	                    break;
	          default:  runMainMenu();
	                    break;
	       }
		
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
		int temp = 0;
		if(size != 0) {
			//loop goes in here
			temp = remView.scrollMenu();
			
			switch (temp){
			    
			    case 0: if(scrollPosition > 0){    
			            remView.displayAppointment(remModel.getAppointment(scrollPosition - 1);
			            scrollPosition -= 1;
			            }
			            
			            else{
			                remView.displayAppointment(remModel.getAppointment(remModel.getSize());
			            }
			                break;
			    case 1: remView.displayAppointment(remModel.getAppointment(scrollPosition + 1);
			            scrollPosition += 1;
			            break;
			    case 3: remModel.removeAppointment(scrollPosition);
			            size = remModel.getSize();
			            break;
			}    
			
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

package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Jtesting {

	@Test
	void addingDeleting() {
		Appointment toAdd;
		RemindersModel newModel = new RemindersModel();
		
		//Make sure the appointment was added to Model's list
		toAdd = new Appointment(2000, 1, 1, 1, 1, 1, "Title", "Description");
		newModel.addAppointment(toAdd);
		assertTrue(newModel.getAppointment(0) != null);
		
		//Testing out of bounds check
		newModel.removeAppointment(5);
		assertTrue(newModel.getAppointment(0) != null);
		
		//Testing if does remove
		newModel.removeAppointment(0);
		assertTrue(newModel.getAppointment(0) == null);
		
		//Testing does not crash on empty list
		newModel.removeAppointment(0);
		
		//Testing add many
		toAdd = new Appointment(2000, 1, 1, 1, 1, 1, "Title", "Description");
		newModel.addAppointment(toAdd);
		toAdd = new Appointment(2000, 2, 2, 2, 2, 2, "Title", "Description");
		newModel.addAppointment(toAdd);
		toAdd = new Appointment(2000, 3, 3, 3, 3, 3, "Title", "Description");
		newModel.addAppointment(toAdd);
		assertTrue(3 == newModel.getSize());
		
		//Testing delete many
		newModel.removeAppointment(0);
		newModel.removeAppointment(0);
		newModel.removeAppointment(0);
		assertTrue(0 == newModel.getSize());
		
	}
	
	@Test
	void addOrdering() {
		Appointment toAdd;
		RemindersModel newModel = new RemindersModel();
		
		//check if year difference added correctly
		toAdd = new Appointment(2001, 2, 2, 2, 2, 2, "Title", "Description");
		newModel.addAppointment(toAdd);
		toAdd = new Appointment(2000, 1, 1, 1, 1, 1, "Title", "Description");
		newModel.addAppointment(toAdd);
		assertTrue(2001 == newModel.getAppointment(1).getYear());
		
		//check if month and day add correctly
		toAdd = new Appointment(2001, 1, 2, 2, 2, 2, "Title", "Description");
		newModel.addAppointment(toAdd);
		toAdd = new Appointment(2001, 2, 3, 2, 2, 2, "Title", "Description");
		newModel.addAppointment(toAdd);
		assertTrue(1 == newModel.getAppointment(1).getMonth());
		assertTrue(3 == newModel.getAppointment(3).getDay());
		
	}
	
	@Test
	void dealingWithTime() {
		Appointment toAdd;
		RemindersModel newModel = new RemindersModel();
		
		//test a simple is due
		toAdd = new Appointment(2000, 1, 1, 1, 1, 1, "Title", "Description");
		newModel.addAppointment(toAdd);
		assertTrue(newModel.dueNow() != null);
		
		//test a simple not due
		newModel.removeAppointment(0);
		toAdd = new Appointment(2222, 1, 1, 1, 1, 1, "Title", "Description");
		newModel.addAppointment(toAdd);
		assertTrue(newModel.dueNow() == null);
		
		
		
	}

}

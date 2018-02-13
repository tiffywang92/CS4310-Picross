package main;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The Model component manages the system data and associated operations on that data.
 * This will be a passive model that has it's data "pulled" by the view and controller,
 * rather than an active one that can "push" updates to the controller and view.
 *
 */
public class RemindersModel {
	
	private ArrayList<Appointment> appointments;
	private Integer year, month, day, hour, minute;
	
	public boolean isEmpty() {
		if(appointments.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Integer getSize() {
		return appointments.size();
	}
	
	/**
	 * Adds appointment to the list in the appropriate position, for consistency
	 * among classes the appointment at position 0 should be the soonest to occur or
	 * the one farthest in the past, check can be implemented much in the same way as
	 * suggestion for isDue 
	 * @param newAppoint - the appointment to add
	 */
	public void addAppointment(Appointment newAppoint) {
		Integer position = null;
		appointments.add(position, newAppoint);
		
	}
	
	public void removeAppointment(Integer toRemove) {
		//check size restraints to avoid seg fault
		if (appointments.size <= 0)
			return;	// list is empty, do nothing
		appointments.remove((int) toRemove);	// does nothing for nonexistent entries
	}
	
	public Appointment getAppointment(Integer toGet) {
		//check size restraints to avoid seg fault
		if (appointments.size <= 0)
			return null;	// list is empty
		try {
			return appointments.get(toGet);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();	// print error message
		}
	}
	
	/**
	 * Checks if there is an appointment due
	 * @return - the appointment that is most past due or null if none exist that are due
	 */
	public Appointment dueNow(){
		//update time, check if list empty, check if appointment at 0 is due/past due (put in isDue for code cleanliness), 
		//if so return it, otherwise or if list is empty return null
		updateTime();
		if (appointments.size > 0 && isDue) {
			return appointments[0];
		}
		return null;
	}
	
	/**
	 * Check the appointment at the starting position against the current time
	 * can check in order year - month - day - hour - minute
	 * can see if value in appointment is less than the current time (signifies a time in the past)
	 * @return - true if appointment is due / past due, false if it is not yet due
	 */
	private boolean isDue() {
		if(!isEmpty()) {
			if (appointments[0].year < year)
				return true;
			if (appointments[0].month < month)
				return true;
			if (appointments[0].day < day)
				return true;
			if (appointments[0].hour < hour)
				return true;
			if (appointments[0].day < day)
				return true;
		}
		return false;
	}
	
	/**
	 * Update all time global variables
	 */
	private void updateTime() {
		LocalDateTime curTime = LocalDateTime.now();
		year = curTime.getYear();
		month = curTime.getMonthValue();
		day = curTime.getDayOfMonth();
		hour = curTime.getHour();
		minute = curTime.getMinute();
	}
	


}

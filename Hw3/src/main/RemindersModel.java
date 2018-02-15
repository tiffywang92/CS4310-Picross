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
	
	public RemindersModel() {
		appointments = new ArrayList<Appointment>();
	}
	
	public boolean isEmpty() {
		if(appointments.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return - How many appointments exist
	 */
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
		if(appointments.size() == 0) {
			appointments.add(newAppoint);
			return;
		}
		Integer position = 0;
		year = newAppoint.getYear();
		month = newAppoint.getMonth();
		day = newAppoint.getDay();
		hour = newAppoint.getHour();
		minute = newAppoint.getMinute();
		
		while(position != appointments.size()) {
			if(isDue(position)) {
				++position;
			}else {
				break;
			}
		}
		
		if(position == appointments.size()) {
			appointments.add(newAppoint);
		}else {
			appointments.add(position, newAppoint);
		}
		
	}
	
	public void removeAppointment(Integer toRemove) {
		if (appointments.size() <= 0)
			return;	// list is empty, do nothing
		
		if(toRemove < 0 || toRemove >= appointments.size())
			return; // out of bounds, do nothing
		
		appointments.remove((int) toRemove);	// does nothing for nonexistent entries
	}
	
	public Appointment getAppointment(Integer toGet) {
		if (appointments.size() <= 0)
			return null;	// list is empty
		
		if(toGet < 0 || toGet >= appointments.size())
			return null;
		
		return appointments.get(toGet);
	}
	
	/**
	 * Checks if there is an appointment due
	 * @return - the appointment that is most past due or null if none exist that are due
	 */
	public Appointment dueNow(){
		//update time, check if list empty, check if appointment at 0 is due/past due (put in isDue for code cleanliness), 
		//if so return it, otherwise or if list is empty return null
		updateTime();
		if (appointments.size() > 0 && isDue()) {
			return appointments.get(0);
		}
		return null;
	}
	
	/**
	 * Check the appointment at the position against the current time stored
	 * can check in order year - month - day - hour - minute
	 * can see if value in appointment is less than the current time (signifies a time in the past)
	 * @return - true if appointment is due / past due, false if it is not yet due
	 */
	private boolean isDue(Integer toTest) {
		if(!isEmpty()) {
			if(toTest >= 0 && toTest < appointments.size()) {
				if (appointments.get(toTest).getYear() < year)
					return true;
				if(appointments.get(toTest).getYear() > year)
					return false;
				
				if (appointments.get(toTest).getMonth() < month)
					return true;
				if (appointments.get(toTest).getMonth() > month)
					return false;
				
				if (appointments.get(toTest).getDay() < day)
					return true;
				if (appointments.get(toTest).getDay() > day)
					return false;
				
				if (appointments.get(toTest).getHour() < hour)
					return true;
				if (appointments.get(toTest).getHour() > hour)
					return false;
				
				if (appointments.get(toTest).getMinute() < minute)
					return true;
				if (appointments.get(toTest).getMinute() > minute)
					return false;
			}
		}
		return false;
	}
	
	/**
	 * Check the appointment at the first position against the current time stored
	 * @return - true if appointment is due / past due, false if it is not yet due
	 */
	private boolean isDue() {
		return isDue(0);
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

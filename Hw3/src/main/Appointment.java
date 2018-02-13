package main;

/**
 * Creates an immutable object that stores all values needed for an appointment
 *
 */
public class Appointment {

	private Integer year, month, day, hour, minute, reminder;
	private String title, description;
	
	public Integer getReminder() {
		return reminder;
	}
	
	public Integer getYear() {
		return year;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getDay() {
		return day;
	}

	public Integer getHour() {
		return hour;
	}

	public Integer getMinute() {
		return minute;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	Appointment(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer reminder, String title, String description){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.title = title;
		this.description = description;
		this.reminder = reminder;
	}
	
	
}

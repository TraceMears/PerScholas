package JavaSBAProject_08;

import java.time.LocalDate;

public class Event {
	int ID;
	String name;
	String description;
	LocalDate date;
	
	public Event(int id, String name, String desc, LocalDate date) {
		this.ID = id;
		this.name = name;
		this.description = desc;
		this.date = date;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}

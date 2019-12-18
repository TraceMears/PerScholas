package classes;

import java.sql.Date;
import java.time.LocalDateTime;

public class User {

	private int userId;
	private String username;
	private String password;
	private Date doB;
	
	public User(int id, String username, String password, Date doB) {
		this.userId = id;
		this.username = username;
		this.password = password;
		this.doB = doB;
	}
	public User(int id, String user, String pass) {
		this.userId = id;
		this.username = user;
		this.password = pass;
	}
	public User(String user, String pass, Date dob) {
		this.username = user;
		this.password = pass;
		this.doB = dob;
	}
	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDoB() {
		return doB;
	}
	public void setDoB(Date doB) {
		this.doB = doB;
	}
	public int getUserId() {
		return userId;
	}	
}

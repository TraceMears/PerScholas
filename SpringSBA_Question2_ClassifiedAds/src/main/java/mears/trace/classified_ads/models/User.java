package mears.trace.classified_ads.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class User {	
	
	@NotBlank(message="Username is required.")
	private String username;
	
	@NotBlank(message="Password is required.")
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
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
}

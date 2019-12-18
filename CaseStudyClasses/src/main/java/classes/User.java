package classes;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String username;
	private String password;
	int count;
	
	private ArrayList<String> favorites = new ArrayList<String>();
	
	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	public User(String user, String pass, int count) {
		this.username = user;
		this.password = pass;
		this.count = count;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addFighterName(String f) {
		this.favorites.add(f);
		count++;
	}
	
	public ArrayList<String> getNamesOfFavorites() {
		return favorites;
	}
	
	public void removeFighter(String f) {
		this.favorites.remove(f);
		count--;
	}
	
	
	
	
}

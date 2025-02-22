package tests;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import DAOs.FighterDAO;
import DAOs.UserDAO;
import classes.Fighter;
import classes.User;

public class UserDAOTests {

	@Test
	public void testConnection() {
		assumeTrue(UserDAO.testConnection());
	}
	
	@Test 
	public void testLogin() {
		assumeTrue(UserDAO.login("Trace", "Racecar37"));
	}
	
//	@Test
//	public void testCreateUser() {
//		User u = new User("Trevor", "Joker1234");
//		assumeTrue(UserDAO.createUser(u));
//	}
	
//	@Test
//	public void testDeleteUser() {
//		assumeTrue(UserDAO.deleteUser("Trevor"));
//	}

//	@Test
//	public void testUpdateUser() {
//		assumeTrue(UserDAO.updateUserPassword("Trevor", "Joker123"));
//	}
	
	@Test
	public void testAddFavorite() {
		assumeTrue(UserDAO.addToFavorites("Trevor", "Stylebender"));
	}
	
	
}

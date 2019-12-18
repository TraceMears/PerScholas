package tests;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import DAOs.FighterDAO;
import classes.Fighter;

public class FighterDAOTests {

	@Test
	public void testConnection() {
		assumeTrue(FighterDAO.testConnection());
	}
	
//	@Test
//	public void testInsert() {
//		assumeTrue(FighterDAO.insertFighter(new Fighter("Israel Adesanya", 4.46, 2.60, 0.00, 0.40, .43, .43)));
//	}
	
	@Test
	public void testDelete() {
//		assumeTrue(FighterDAO.deleteFighter(change number));
	}

	@Test
	public void testUpdate() {
		assumeTrue(FighterDAO.updateFighter("Israel Adesanya", 4.46, 2.60, 0.00, 0.40, .43, .69));
	}
	
	@Test
	public void testGetList() {
		
		ArrayList<String> list = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
			add("Israel Adesanya");
			add("Izzy Adesanya");
			add("Stylebender");
			add("The Last Stylebender");
			}
		};

		FighterDAO.retrieveListOfFighters(list);
		
	}
	
}

package mears.trace.stats_application.DAOs;

import mears.trace.stats_application.models.Fighter;

public class DAOMain {

	public static void main(String[] args) {
		
		FighterDAO.testConnection();
		Fighter f = new Fighter(
				"Israel Adesanya", 4.46, 2.60, 0.00, 0.40, .43, .43);
		
		FighterDAO.insertFighter(f);
		
//		FighterDAO.updateFighter("Israel Adesanya", 4.46, 2.60, 0.00, 0.40, .43, .43);
	}

}

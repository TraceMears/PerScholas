package file.order.dao.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderFileHandler {
	
	public static List<Order> readOrder(String fileName) throws FileNotFoundException, IOException,
																NumberFormatException, InvalidQuantityException {
		
		List<Order> orderList = new ArrayList<Order>();
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		String[] lineValues = new String[2];
		
		while( (line = br.readLine()) != null) {
			lineValues = line.split(" ");
			orderList.add(OrderDAO.retrieveByName(lineValues[0], Integer.parseInt(lineValues[1])));
		}		
		br.close();
		return orderList;
	}
}

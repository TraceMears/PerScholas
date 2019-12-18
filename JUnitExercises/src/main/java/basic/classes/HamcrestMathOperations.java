package basic.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HamcrestMathOperations {
	
	public static int abstractOperation1(int num1, int num2, int num3) {
		return num1 + (num2 * num3);
	}
	
	public static int abstractOperation2(int num1, int num2, int num3) {
		return (num1 + num2) * num3;
	}
	
	public static double abstractOperation3(double num1, double num2, double num3, double num4) {
		return (num1 * num2) * (num3 / num4);
	}
	
	public static List<Integer> listOfCubes() {
		List<Integer> cubeList = new ArrayList<Integer>();
		for (int i=0; i<=10; i++) {
			cubeList.add((int) Math.pow(i, 3));
		}
		return cubeList;
	}
	
	public static Map<String, String> capitals(){
		Map<String, String> capitalCities = new HashMap<String, String>();
		String[] capitals = {"Washington DC", "Quito", "Tegucigalpa", "Tehran", "Ankara", "Brasilia",
							"Astana", "Kiev", "Copenhagen", "Managua"};
		String[] countries = {"United States", "Ecuador", "Honduras", "Iran", "Turkey", "Brazil",
							"Khazakstan", "Ukraine", "Denmark", "Nicaragua"};
		for (int i=0; i<capitals.length && i<countries.length; i++) {
			capitalCities.put(capitals[i], countries[i]);
		}		
		return capitalCities;
	}
}

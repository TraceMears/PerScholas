package JavaSBAProject_Bonus;

public class CustomException {

	public static void main(String[] args) {
	
		int[] array = {0, 1, 2, 3, 4, 5};
		int test = 6;
		
		try {
			array[6] = test;
			System.out.println("Properly accessed array");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("You tried to access an out of bounds index");
		}
	}
}

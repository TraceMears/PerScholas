package JavaSBAProject_03;

import java.util.Scanner;

public class CourseDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter course ID");
		int courseID =  Integer.parseInt( scan.nextLine() );
		
		System.out.println("Enter course name");
		String courseName = scan.nextLine();
		
		System.out.println("Provide brief course description");
		String courseDescription = scan.nextLine();
		
		Course course = new Course(courseID, courseName, courseDescription);
		
		System.out.println(course) ;
		
		
		scan.close();

	}

}

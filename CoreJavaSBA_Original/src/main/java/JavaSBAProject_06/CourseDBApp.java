package JavaSBAProject_06;


// need a DB named Courses with table names course at localhost:1234 to run program


public class CourseDBApp {

	public static void main(String[] args) {
		
		//test connection
		CourseDAO.connect();
		System.out.println();
				
		//insert 3 courses
		CourseDAO.createCourse("French Literature", "Introduction to French literature");
		CourseDAO.createCourse("Calculus", "Introductory derivatives");
		CourseDAO.createCourse("Calculus II", "Integrals and series calculations");
		System.out.println();
		
		//delete method
		CourseDAO.deleteCourse(4);
		
		//print all courses
		CourseDAO.retreiveAllCourses();
		System.out.println();
		
		//print a course by name
		CourseDAO.retreiveByName("Algebra");
		System.out.println();
		
		//update first course in table
		CourseDAO.updateFirstCourse("Math", "Introduction to Math");
		
		

	}

}

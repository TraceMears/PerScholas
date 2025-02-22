package questionz10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstructorTests {
	
	@Category( { DailyTests.class} )
	@Test
	public void gradeAssignmentTest() {
		System.out.println("InstructorTests gradeAssignmentTest.");
	}
	
	@Category( { WeeklyTests.class} )
	@Test
	public void gradeExamTest() {
		System.out.println("InstructorTests gradeExamTest.");
	}
	
	@Category( { SemesterTests.class} )
	@Test
	public void submitFinalGradesTest() {
		System.out.println("InstructorTests submitFinalGradesTest.");
	}
	
	@Category( { SemesterTests.class} )
	@Test
	public void adviseStudentTest() {
		System.out.println("InstructorTests adviseStudentTest.");
	}
}


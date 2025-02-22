package questionz10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StudentTests {
	
	@Category( { DailyTests.class} )
	@Test
	public void submitAssignmentTest() {
		System.out.println("StudentTests submitAssignmentTest.");
	}
	
	@Category( { WeeklyTests.class} )
	@Test
	public void submitExamTest() {
		System.out.println("StudentTests submitExamTest.");
	}
	
	@Category( { SemesterTests.class} )
	@Test
	public void joinClubTest() {
		System.out.println("StudentTests joinClubTest.");
	}
}

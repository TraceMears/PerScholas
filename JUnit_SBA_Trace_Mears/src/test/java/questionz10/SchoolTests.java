package questionz10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SchoolTests {
	
	@Category( { SemesterTests.class} )
	@Test
	public void addCourseTest() {
		System.out.println("SchoolTests addCourseTest.");
	}
	
	@Category( { SemesterTests.class} )
	@Test
	public void registerStudentTest() {
		System.out.println("School Tests registerStudentTest.");
	}
	
	@Category( { WeeklyTests.class} )
	@Test
	public void createWeeklyReportTest() {
		System.out.println("School Tests createWeeklyReportTest.");
	}
	
	@Category( { DailyTests.class} )
	@Test
	public void takeAttendanceTest() {
		System.out.println("School Tests takeAttendanceTest.");
	}
	
	@Category( { SemesterTests.class} )
	@Test
	public void publishGradesTest() {
		System.out.println("School Tests publishGradesTest.");
	}
}


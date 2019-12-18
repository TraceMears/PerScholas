package questionz10;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@Categories.IncludeCategory({DailyTests.class})
@SuiteClasses({ questionz10.SchoolTests.class,
				questionz10.StudentTests.class,
				questionz10.InstructorTests.class
				})


public class Suite_Daily {

}

package question4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ question1.StringUnitTests.class,
				question2.Split_and_Join_tests.class,
				question3.BinaryStringTest.class
				})

public class SuiteOfTests {

}

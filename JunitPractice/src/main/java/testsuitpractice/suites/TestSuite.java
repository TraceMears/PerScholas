package testsuitpractice.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestClass1.class,
				TestClass2.class,
				TestClass3.class})


public class TestSuite {

}

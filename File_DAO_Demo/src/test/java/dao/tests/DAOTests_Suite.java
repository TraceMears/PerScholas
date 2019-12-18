package dao.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { 
				OrderClassTests.class,
				OrderDAOTests.class,
				FileHandlerTest.class
				})

public class DAOTests_Suite {

}

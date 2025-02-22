package question6;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import question5_classes.InvalidPasswordException;
import question5_classes.User;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UserParameterizedTest {
	
	private Integer userId;
	private String name;
	private String password;
	private Double javaScore;
	private Double sqlScore;
	private Integer expectedCredits;
	Class <? extends Exception> expectedException;
	
	
	User badInput = new User();
		
	public UserParameterizedTest(Integer userId, String name, String password, Double javaScore,
									Double sqlScore, Integer expectedCredits, Class <? extends Exception> expectedException)  {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
		this.expectedCredits = expectedCredits;
		this.expectedException = expectedException;
		
	}
	
	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ 1, "trace", "trace12345", 85.0, 90.0, 2, null },
                		{ 2, "tom", "tom12345", 80.0, 65.0, 1, null },
                		{ 3, "salah", "sheber", 100.0, 100.0, 2, InvalidPasswordException.class },
                		{ 4, "chen", "chen12345", 69.0, 69.0, 0, null },
                		{ 5, "goutham23", "goutham12345", 90.0, 90.0, 2, IllegalArgumentException.class }
                		});
    }
    
    @Rule
    public ExpectedException ee = ExpectedException.none();
      
    @Test
	public void testCalculateCredits() throws InvalidPasswordException {
    	
    	if(expectedException != null) {
    		ee.expect(expectedException);
    		
    	}
    	
    	User u = new User(userId, name, password, javaScore, sqlScore);
    	assertThat(u.calculateCredits(), equalTo(expectedCredits));    	
    }
}

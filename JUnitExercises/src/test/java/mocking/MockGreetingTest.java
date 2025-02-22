package mocking;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class MockGreetingTest {

	Greeting mockGreeting = Mockito.mock(Greeting.class);
		
	@Test
	public void test() {
		when(mockGreeting.selectLanguage(2)).thenReturn("Spanish");
		assertThat(mockGreeting.selectLanguage(2), equalTo("Spanish"));
	}

}

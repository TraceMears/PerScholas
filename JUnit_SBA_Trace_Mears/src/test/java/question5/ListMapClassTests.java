package question5;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import question5_classes.InvalidPasswordException;
import question5_classes.ListMapClass;
import question5_classes.User;

public class ListMapClassTests {

	ListMapClass lmc = new ListMapClass();
	
	@Test
	public void citiesTest() {
		List<String> cities = lmc.cities();
		assertThat(cities, everyItem(is(not("Asheville"))));
		assertThat(cities, anyOf(hasItems("Dallas", "Boston"), hasItems("Seoul")));
		assertThat(cities, allOf(hasItems("Dallas"), not(hasItems("Asheville"))));
	}
	
	@Test
	public void userListTest() throws InvalidPasswordException {
		List<User> users = lmc.getUserList();
		assertThat(users.get(2).calculateCredits(), equalTo(2));
		assertThat(users.get(1).getJavaScore(), equalTo(88.0));
		assertThat(users.get(0).getPassword(), equalTo("john1234"));
	}

	@Test
	public void courseMapTest() {
		Map<String, String> courses = lmc.getCoursesMap();
		assertThat(courses, hasEntry("DE", "Data Engineering"));
		assertThat(courses, hasKey("JD"));
		assertThat(courses, hasValue("Quality Engineering and Assurance"));
	}
	
	@Test
	public void userMapTest() throws InvalidPasswordException {
		Map<Integer, User> users = lmc.getUserMap();
		assertThat(users.get(10).calculateCredits(), not(equalTo(1)));
		assertThat(users.get(11).getJavaScore(), allOf((greaterThan(85.0)), (lessThan(90.0))));
		assertThat(users.get(12).getPassword(), anyOf(equalTo("john1234"), equalTo("jose1234"), equalTo("jovita1234"), equalTo("jackie1234")));
	
	}
}

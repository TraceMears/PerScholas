package springcoreproject_02.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import springcoreproject_02.greeting_interface.GreetingService;

public class Person {
	
	@Autowired
	//@Qualifier("spanish")
	private GreetingService gs;
	
	public Person() {
		
	}
	public Person(GreetingService gs) {
		this.gs = gs;
	}

	public GreetingService getGs() {
		return gs;
	}

	public void setGs(GreetingService gs) {
		this.gs = gs;
	}
	
}

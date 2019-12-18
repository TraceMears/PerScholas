package springcoreproject_02.models;

import springcoreproject_02.greeting_interface.GreetingService;

public class Person {
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

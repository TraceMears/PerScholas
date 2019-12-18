package springcoreproject_02.greeting_interface.impl;

import springcoreproject_02.greeting_interface.GreetingService;

public class EnglishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		return "Hello";
	}

	@Override
	public String sayWelcome() {
		return "Welcome";
	}

}

package springcoreproject_02.greeting_interface.impl;

import springcoreproject_02.greeting_interface.GreetingService;

public class SpanishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		return "Hola";
	}

	@Override
	public String sayWelcome() {
		return "Bienvenidos";
	}

}

package springcoreproject_02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springcoreproject_02.greeting_interface.impl.*;
import springcoreproject_02.models.Person;

@Configuration
public class GreetingConfig {
	
	@Bean("personEnglish")
	public Person personE() {
		return new Person();
	}
	@Bean("english")
	public EnglishGreeting english() {
		return new EnglishGreeting();
	}
	
	@Bean("personSpanish")
	public Person personS() {
		return new Person();
	}
	@Bean("spanish")
	public SpanishGreeting spanish() {
		return new SpanishGreeting();
	}
}

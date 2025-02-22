package springcoreproject_02.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springcoreproject_02.config.GreetingConfig;
import springcoreproject_02.models.Person;

public class GreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(GreetingConfig.class);
		Person pE = context.getBean("personEnglish", Person.class);
		Person pS = context.getBean("personSpanish", Person.class); 
		
		
		System.out.println(pE.getGs().sayHello());
		System.out.println(pS.getGs().sayWelcome());
	}

}

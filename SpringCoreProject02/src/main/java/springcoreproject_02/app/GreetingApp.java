package springcoreproject_02.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springcoreproject_02.models.Person;

public class GreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("/springcoreproject_02/bean_def/BeanDef.xml");
		Person p = context.getBean("personSpanish", Person.class); 
		
		System.out.println(p.getGs().sayHello());
	}

}

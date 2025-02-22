package springcoreproject_01.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springcoreproject_01.models.SpringGreeting;

public class SpringGreetingApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("/springcoreproject_01/bean_def/BeanDef.xml");
		SpringGreeting sg = context.getBean("SpringGreeting", SpringGreeting.class); 
		
		System.out.println(sg.returnString());
		
		context.close();
	}
	
}

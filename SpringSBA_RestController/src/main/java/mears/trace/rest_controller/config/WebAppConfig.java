package mears.trace.rest_controller.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import mears.trace.rest_controller.models.Student;

@Configuration
@ComponentScan("mears.trace.rest_controller")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
		
		//can also do ^^^ this way:
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");		
	}
	
	@Bean
	ObjectMapper objectMapper() {
		// INDENT_OUTPUT allows for "pretty printing" of JSON data
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//Map to emulate database
	@Bean
	Map<Integer, Student> studentMap() {
		Map<Integer, Student> sMap = new HashMap<>();
		Student student;
		// Create first student record
		student = new Student(1, "Trace", "trace@gmail.com");
		student.getCourses().add("Math");
		student.getCourses().add("Science");
		sMap.put(student.getStudentId(), student);
		// Create second student record
		student = new Student(2, "Jane", "jane@SouthHarmon.edu");
		student.getCourses().add("History");
		student.getCourses().add("Physics");
		sMap.put(student.getStudentId(), student);
		// Create first student record
		student = new Student(3, "Anthony", "ant@hotmail.com");
		student.getCourses().add("Art");
		student.getCourses().add("Home education");
		sMap.put(student.getStudentId(), student);
		return sMap;
	}
}

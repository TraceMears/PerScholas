package mears.trace.rest_controller.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mears.trace.rest_controller.models.Student;

@RestController
public class RestControllerImpl {
	
	private Map<Integer, Student> studentMap;
	private ObjectMapper  mapper;
	
	@Autowired
	public RestControllerImpl(Map<Integer, Student> studentMap, 
			ObjectMapper mapper) {
		this.mapper = mapper;
		this.studentMap = studentMap;
	}
	
	@GetMapping(value = "/hello", produces = "text/html")
	public String showStringMessage() {
		return "<h1 style='color: red;'>Hello from @RestController!</h1>";
	}
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable Integer id) throws JsonProcessingException {
			if (studentMap.get(id) != null) {
			Student student = studentMap.get(id);
			return mapper.writeValueAsString(student);
		} 
		// The error String is returned to the web client
		return "Student ID not found";
	}
	@GetMapping("/getAllStudents")
	public String getAllStudent() throws JsonProcessingException {
		return mapper.writeValueAsString(this.studentMap);
	}
}
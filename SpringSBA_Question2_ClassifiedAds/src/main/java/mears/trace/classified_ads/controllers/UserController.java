package mears.trace.classified_ads.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mears.trace.classified_ads.models.User;
import mears.trace.classified_ads.repositories.ItemRepository;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {
	
	@Autowired
	ItemRepository repo;
	
	@RequestMapping("/")
	public String showLoginPage(Model model) {
		model.addAttribute("loginAttempt", new User());
		return "Login";
	}	
	
	@PostMapping("/login")
	public String validateLogin(@Valid @ModelAttribute("loginAttempt")User user, HttpSession sesh) {
		User userCredentials = (User) sesh.getAttribute("credentials");
		if( user.getUsername().equals( userCredentials.getUsername() ) && 
				user.getPassword().equals( userCredentials.getPassword() ) ) {
			return "forward:/showClassified";
		}
		return "redirect:/";
	}
	
	@GetMapping("/registration")
	public String goToRegistration(Model model) {
		model.addAttribute("user", new User());
		return "Register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, Model model, HttpSession sesh) {
		sesh.setAttribute("credentials", user);		
		model.addAttribute("loginAttempt", new User());
		return "Login";
	}
	
	
}

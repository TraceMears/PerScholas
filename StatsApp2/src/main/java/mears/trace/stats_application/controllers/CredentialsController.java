package mears.trace.stats_application.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mears.trace.stats_application.models.User;
import mears.trace.stats_application.repositories.UserRepository;

@Controller
public class CredentialsController {

	@Autowired
	UserRepository repo;
	
	@RequestMapping("/")
	public String showLoginPage(Model model) {
		model.addAttribute("loginAttempt", new User());
		return "Login";
	}
	
	@PostMapping("/login")
	public String validateLogin(@Valid @ModelAttribute("loginAttempt")User user, HttpSession sesh) {
		
		if(repo.login(user.getUsername(), user.getPassword()) == null) {
			return "redirect:/";
		}
		User u = repo.login(user.getUsername(), user.getPassword());
		sesh.setAttribute("loggedUser", u);	
		return "redirect:/userPage";
	}
	
	@GetMapping("/registration")
	public String goToRegistration(Model model) {
		model.addAttribute("user", new User());
		return "Register";
	}
		
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user) {
		repo.createUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession sesh) {
		sesh.invalidate();
		return "redirect:/";
	}
}

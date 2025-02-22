package springbasic.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showWelcomePage(Model model) {	
		model.addAttribute("datetime", LocalDateTime.now());
		return "Welcome";
	}
	
	@GetMapping("/Login")
	public String loginForm() {
		return "Login";
	}
	
	@PostMapping("/getLogin")
	public String showLoginPage(HttpSession sesh, @RequestParam String username, @RequestParam String password) {
		sesh.setAttribute("user", username);
		sesh.setAttribute("pass", password);
		return "Result";
	}
	
	@RequestMapping("/Hello")
	public String showIndexPage() {
		return "Hello";
	}	
	
	@RequestMapping("/Congrats")
	public String showCongratulationsPage() {
		return "Congratulations";
	}
	
	
}

package mears.trace.stats_application.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mears.trace.stats_application.models.User;
import mears.trace.stats_application.repositories.UserRepository;

@Controller
public class AdminController {

	@Autowired
	UserRepository repo;
	
	@GetMapping("/adminPage")
	public String AdminPage(Model model) {
		model.addAttribute("allUsers", repo.getAllUsers());
		return "AdminPage";
	}	

	@GetMapping("/admin")
	public String goToAdminLogin(Model model) {
		model.addAttribute("adminLogin", new User());
		return "AdminLogin";
	}
	
	@PostMapping("/adminLogin")
	public String adminLogin(@Valid @ModelAttribute("adminLogin")User user) {
		
		if( repo.adminLogin(user.getUsername(), user.getPassword()) == null) {
			return "redirect:/admin";
		}
		
		return "redirect:/adminPage";
	}
	
	@GetMapping("/updateDB")
	public String updateFighterDB(Model model) {
//		model.addAttribute("user", new User());
		return "AdminUpdate";
	}
	
	@PostMapping("/banUser")
	public String banUser(@RequestParam("Ban_User") Integer uId, Model model) {
		
		if(uId == null) {
			return "redirect:/adminPage";
		}		
		User u = repo.getUser(uId);
		if(u == null) {
			return "redirect:/adminPage";
		}
		model.addAttribute("bannedUser", u);	
		
		repo.deleteUser(uId);
		model.addAttribute("allUsers", repo.getAllUsers());
		return "AdminPage";
	}
}

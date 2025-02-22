package mears.trace.stats_application.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mears.trace.stats_application.models.Favorite;
import mears.trace.stats_application.models.Fighter;
import mears.trace.stats_application.models.User;
import mears.trace.stats_application.repositories.FighterRepository;
import mears.trace.stats_application.repositories.UserRepository;
import mears.trace.stats_application.sub_methods.UserMethods;

@Controller
public class UserController {
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	FighterRepository fRepo;
	
	@GetMapping("/userPage")
	public String showUserPage(Model model, HttpSession sesh) {
		model.addAttribute("fighterTemplate", new Fighter());
		model.addAttribute("allFighters", fRepo.showFighters());
		User u = (User) sesh.getAttribute("loggedUser");
		List<Favorite> fList = uRepo.getFavoriteList(u);
		List<Integer> fighterIdList = UserMethods.returnFavoriteIds(fList);
		List<Fighter> favoriteFightersList = fRepo.getFavoriteFighters(fighterIdList);
		model.addAttribute("favoriteFightersList", favoriteFightersList);
		
		return "UserPage";
	}
	
	@GetMapping("/updatePage")
	public String goToRegistration() {
		return "UpdatePassword";
	}
	
	@GetMapping("/deletePage")
	public String deletePage() {
		return "DeletePage";
	}
	
	@PostMapping("/deleteUser")
	public String deleteAccount(HttpSession sesh) {
		User u = (User) sesh.getAttribute("loggedUser");
		uRepo.deleteUser(u.getId());
		return "forward:/";
	}
	
	@PostMapping("/changePass")
	public String changePassword(@RequestParam("newPass") String pass1, 
								@RequestParam("newPass2") String pass2,
								HttpSession sesh) {
		if( !pass1.equals(pass2) ) {
			return "redirect:/updatePage";
		}
		User u = (User) sesh.getAttribute("loggedUser");
		u.setPassword(pass1);
		uRepo.updatePassword(u);
		return "redirect:/userPage";
	}
	
	@PostMapping("/addToFavorites")
	public String addFavorite(@RequestParam("Add_Fighter") Integer fId,
								HttpSession sesh) {
		if(fId == null) {
			return "redirect:/userPage";
		}
		User u = (User) sesh.getAttribute("loggedUser");
		if( u.getCount() > 4) {
			return "redirect:/userPage";
		}
		System.out.println(u.getCount());
		uRepo.addToFavorites(u, fId);
		u.setCount(u.getCount() + 1);		
		sesh.setAttribute("loggedUser", u);		
		
		return "redirect:/userPage";
	}	
		
	@GetMapping("/removeFavorite/{fId}")
	public String removeFavorite(@PathVariable Integer fId,
								HttpSession sesh) {
		User u = (User) sesh.getAttribute("loggedUser");
		if( !(u.getCount() > 0) ) {
			return "redirect:/userPage";
		}		
		uRepo.removeFavorite(u, fId);
		u.setCount(u.getCount() - 1);		
		sesh.setAttribute("loggedUser", u);		
		
		return "redirect:/userPage";
	}
	
	
}

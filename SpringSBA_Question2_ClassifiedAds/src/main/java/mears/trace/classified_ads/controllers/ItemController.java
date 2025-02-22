package mears.trace.classified_ads.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mears.trace.classified_ads.models.Item;
import mears.trace.classified_ads.models.User;
import mears.trace.classified_ads.repositories.ItemRepository;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ItemController {

	@Autowired
	ItemRepository repo;
	
	@RequestMapping("/showClassified")
	public String showClassified(HttpSession sesh, Model model) {
		User u = (User) sesh.getAttribute("credentials");
		model.addAttribute("displayName", u.getUsername());
		List<Item> allItems = repo.showItems();
		model.addAttribute("item", new Item());
		model.addAttribute("allItems", allItems);
		return "adsPage";
	}	
	
	@PostMapping("/addItem")
	public String addItem(@Valid @ModelAttribute("item")Item item, Model model) {
		Integer itemId = repo.addItem(item);
		if(itemId == -1) {
			model.addAttribute("errorMessage", "Add item failed");
			return "forward:/showClassified";
		}		
		return "redirect:/showClassified";
	}
	
	@GetMapping("/orderItem/{itemId}")
	public String orderItem(@PathVariable Integer itemId) throws IOException, SQLException {
		repo.updateOrderStatus(itemId, 1);
		return "redirect:/showClassified";
	}
	
	@GetMapping("/cancelOrder/{itemId}")
	public String cancelOrder(@PathVariable Integer itemId) throws IOException, SQLException {
		repo.updateOrderStatus(itemId, 0);
		return "redirect:/showClassified";
	}
	
}

package mears.trace.stats_application.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mears.trace.stats_application.models.Fighter;
import mears.trace.stats_application.models.User;
import mears.trace.stats_application.repositories.FighterRepository;

@Controller
public class TableController {
	
	@Autowired
	FighterRepository fRepo;
	
	@GetMapping("/tableView")
	public String showTablePage(Model model, HttpSession sesh) {
		model.addAttribute("allFighters", fRepo.showFighters());
		if ( (Integer) sesh.getAttribute("tableCounter") == null ) {
			sesh.setAttribute("tableCounter", 0);
		}		
		
		if( (List<Fighter>) sesh.getAttribute("tableList") == null ) {
			sesh.setAttribute("tableList", new ArrayList<Fighter>());
		}
		
		return "TableView";
	}
	
	@PostMapping("/addToTable")
	public String addToTable(@RequestParam("Add_Fighter") Integer fId,
								HttpSession sesh) {
		if(fId == null) {
			return "redirect:/tableView";
		}
		
		Integer count = (Integer) sesh.getAttribute("tableCounter");
		if( count > 9) {
			return "redirect:/tableView";
		}
		
		@SuppressWarnings("unchecked")
		List<Fighter> tableList = (List<Fighter>) sesh.getAttribute("tableList");
		tableList.add( fRepo.retrieveFighter(fId) );
		sesh.setAttribute("tableList", tableList);
		
		count = count + 1;
		sesh.setAttribute("tableCounter", count);
		
		return "redirect:/tableView";
	}
	
	@GetMapping("/removeFromTable/{fId}")
	public String removeFavorite(@PathVariable Integer fId,
								HttpSession sesh) {

		Integer count = (Integer) sesh.getAttribute("tableCounter");
		if( count < 1) {
			return "redirect:/tableView";
		}
		
		@SuppressWarnings("unchecked")
		List<Fighter> tableList = (List<Fighter>) sesh.getAttribute("tableList");
		
		for(Iterator<Fighter> it = tableList.iterator(); it.hasNext();) {
			Fighter f = it.next();
			if(f.getId() == fId) {
				it.remove();
			}
		}		
		 
		sesh.setAttribute("tableList", tableList);
		
		count = count - 1;
		sesh.setAttribute("tableCounter", count);
		
		return "redirect:/tableView";
	}	
}

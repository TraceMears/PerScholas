package com.perscholas.software_developer_club.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.perscholas.software_developer_club.dao.MemberDAO;
import com.perscholas.software_developer_club.models.Member;

@Controller
@SessionAttributes
public class MemberController {

	@GetMapping("/")
	public String showLogin() {
		return "LoginPage";
	}
	
	@PostMapping("/loginMember")
	public String loginMember(HttpSession sesh, Model model, 
							@RequestParam String name, @RequestParam String password) 
									throws ClassNotFoundException, IOException, SQLException {
		
		MemberDAO m_dao = new MemberDAO();
		Member m = m_dao.getMemberByName(name);
		
		if (m != null ) {
			if (password.equals(m.getPassword())) {
				sesh.setAttribute("currentMember", m);
				return "Welcome";
			} else {
				model.addAttribute("errorMessage", "Invalid login-password");
				return "LoginPage";
			}
		} else {
			model.addAttribute("errorMessage", "Invalid login-user name");
			return "LoginPage";
		}
	}
}

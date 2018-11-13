package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String register(User user){
		userService.insert(user);
		return "redirect:/ems/login.jsp";
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpServletRequest request){
		User u = userService.queryByUsernameAndPassword(username, password);
		if(u!=null){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("login", u);
			return "redirect:/emp/showAllEmployees";
		}else{
			return "redirect:/ems/login.jsp";
		}
		
	}
}

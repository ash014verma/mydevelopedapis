package com.ashish.demo.spring.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap map, Principal principal) {
		map.addAttribute("username",principal.getName());
		map.addAttribute("message", "Spring Security Example");
		return "hello";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

}

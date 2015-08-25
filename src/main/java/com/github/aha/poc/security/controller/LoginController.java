package com.github.aha.poc.security.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @see http://www.journaldev.com/8748/spring-4-mvc-security-managing-roles-example
 */
@Controller
public class LoginController {

//	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
//	public String welcomePage() {
//		return "index";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Map<String, Object> model) {

		if (error != null) {
			model.put("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.put("message", "Logged out finished successfully.");
		}

		return "loginPage";
	}
}

package com.github.aha.poc.security.controller;

import static com.github.aha.poc.security.controller.ActionConsts.ADMIN;
import static com.github.aha.poc.security.controller.ActionConsts.LOGIN;
import static com.github.aha.poc.security.controller.ActionConsts.USER;

import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

/**
 * @see http://www.journaldev.com/8748/spring-4-mvc-security-managing-roles-example
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

	private final MessageSource resource;

	@GetMapping(value = LOGIN)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Map<String, Object> model) {

		if (error != null) {
			model.put("loginMessage", resource.getMessage("login.failed", null, LocaleContextHolder.getLocale()));
		}

		if (logout != null) {
			model.put("loginMessage", resource.getMessage("login.successful", null, LocaleContextHolder.getLocale()));
		}

		return "login";
	}
	
	@GetMapping(value = USER)
	@PreAuthorize("hasRole('ROLE_DEVELOPERS') or principal.username == 'aha'")
	public String userPage(Map<String, Object> model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails ud = ((UserDetails)principal);
			model.put("userDetail", ud);
		}

		return "user";
	}

	@GetMapping(value = ADMIN)
	@RolesAllowed("ROLE_ADMINS")
	public String adminPage() {
		return "admin";
	}

}

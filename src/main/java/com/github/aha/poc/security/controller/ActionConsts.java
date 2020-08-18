package com.github.aha.poc.security.controller;

public class ActionConsts {

	private ActionConsts() {
		throw new IllegalStateException("Utility class");
	}

	public static final String ROOT = "/";

	public static final String LOGIN = "/login";

	public static final String WELCOME = "/welcome";

	public static final String HOME = "/home";

	public static final String USER = "/user";

	public static final String ADMIN = "/admin";

	public static final String ERROR_403 = "/error403";

}

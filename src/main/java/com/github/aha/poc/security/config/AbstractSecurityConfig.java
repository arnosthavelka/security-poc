package com.github.aha.poc.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.github.aha.poc.security.controller.ActionConsts;

public abstract class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(ActionConsts.ROOT, ActionConsts.HOME).permitAll()
				// .antMatchers(ActionConsts.ADMIN).access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated().and()
			.formLogin()
				.loginPage(ActionConsts.LOGIN)
				.defaultSuccessUrl(ActionConsts.HOME)
				.permitAll()
				.usernameParameter("username").passwordParameter("password").and()
			.logout()
				.permitAll();

	}
}

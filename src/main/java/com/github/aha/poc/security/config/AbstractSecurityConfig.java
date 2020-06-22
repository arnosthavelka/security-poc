package com.github.aha.poc.security.config;

import static com.github.aha.poc.security.controller.ActionConsts.HOME;
import static com.github.aha.poc.security.controller.ActionConsts.LOGIN;
import static com.github.aha.poc.security.controller.ActionConsts.ROOT;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public abstract class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(ROOT, HOME, "/actuator/**").permitAll()
				
				// .antMatchers(ActionConsts.ADMIN).access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated().and()
			.formLogin()
				.loginPage(LOGIN)
				.defaultSuccessUrl(HOME)
				.permitAll()
				.usernameParameter("username").passwordParameter("password").and()
			.rememberMe()
				.tokenValiditySeconds(2419200)
				.key("ahaKey").and()
			.logout()
				.permitAll();

	}
}

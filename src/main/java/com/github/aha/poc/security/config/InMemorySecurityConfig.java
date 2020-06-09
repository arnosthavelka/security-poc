package com.github.aha.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@Profile("IN_MEMORY")
public class InMemorySecurityConfig extends AbstractSecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
				.withUser("aha").password("{noop}aha").authorities("ROLE_USER")
		.and()
				.withUser("admin").password("{noop}admin").authorities("ROLE_USER", "ROLE_ADMIN");
	}

}
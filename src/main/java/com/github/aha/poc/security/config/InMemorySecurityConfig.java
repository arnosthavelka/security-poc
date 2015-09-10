package com.github.aha.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@ConditionalOnProperty(prefix = "auth", name = "type", havingValue = "IN_MEMORY", matchIfMissing = true)
public class InMemorySecurityConfig extends AbstractSecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
		.withUser("aha").password("aha").authorities("ROLE_USER")
		.and()
		.withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN");
	}

}
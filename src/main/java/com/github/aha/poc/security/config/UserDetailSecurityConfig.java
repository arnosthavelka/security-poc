package com.github.aha.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@Profile("USER_DETAIL_SERVICE")
public class UserDetailSecurityConfig extends AbstractSecurityConfig {
	
	@Autowired
	private UserDetailsJdbcService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.userDetailsService(userService); // NOSONAR
	}

}

package com.github.aha.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import lombok.RequiredArgsConstructor;

@Configuration
@Profile("USER_DETAIL_SERVICE")
@RequiredArgsConstructor
public class UserDetailSecurityConfig extends AbstractSecurityConfig {
	
	private final UserDetailJdbcService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.userDetailsService(userService); // NOSONAR
	}

}

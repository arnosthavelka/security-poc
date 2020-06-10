package com.github.aha.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @see https://www.baeldung.com/spring-security-5-default-password-encoder
 */
@Configuration
@Profile("IN_MEMORY")
public class InMemorySecurityConfig extends AbstractSecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		authenticationMgr.inMemoryAuthentication()
				.withUser("aha").password(encoder.encode("aha")).authorities(
						"ROLE_USER")
		.and()
				.withUser("admin").password(encoder.encode("admin")).authorities("ROLE_USER", "ROLE_ADMIN");
	}

}
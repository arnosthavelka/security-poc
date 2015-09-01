package com.github.aha.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
//@ConditionalOnClass(org.apache.directory.server.core.DefaultDirectoryService.class)
@ConditionalOnProperty(prefix = "auth", name = "type", havingValue = "APACHE_DS")
public class ApacheDsSecurityConfig extends AbstractSecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.ldapAuthentication()
		.userDnPatterns("uid={0},ou=people")
		.groupSearchBase("ou=groups")
		.contextSource().ldif("classpath:test-server.ldif");
	}

}

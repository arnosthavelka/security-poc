package com.github.aha.poc.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import lombok.RequiredArgsConstructor;

@Configuration
@Profile("JDBC")
@RequiredArgsConstructor
public class JdbcSecurityConfig extends AbstractSecurityConfig {
	
	private final DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, passwd, 1 from u_principal where username = ?")
				.authoritiesByUsernameQuery(
						"select p.username, 'ROLE_' + r.name from u_role r, u_principal p where p.id = r.user_id and p.username = ?");
	}
}

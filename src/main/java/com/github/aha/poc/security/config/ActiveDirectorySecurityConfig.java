package com.github.aha.poc.security.config;

import static com.github.aha.poc.security.controller.ActionConsts.ADMIN;
import static com.github.aha.poc.security.controller.ActionConsts.HOME;
import static com.github.aha.poc.security.controller.ActionConsts.LOGIN;
import static com.github.aha.poc.security.controller.ActionConsts.ROOT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
@Profile("AD")
public class ActiveDirectorySecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Value("${auth.ad.domain}")
    private String domain;

    @Value("${auth.ad.url}")
    private String url;
    
    @Value("${auth.ad.filter}")
    private String filter;

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(ROOT, HOME).permitAll()
				.antMatchers(ADMIN).access("hasRole('ROLE_ADMINS')")
				.anyRequest().authenticated().and()
			.formLogin()
				.loginPage(LOGIN)
				.defaultSuccessUrl(HOME)
				.permitAll()
				.usernameParameter("username").passwordParameter("password").and()
			.logout()
				.permitAll();

	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) {
		authenticationMgr.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	}

    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
         ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(domain, url);
         provider.setUseAuthenticationRequestCredentials(true);
         provider.setConvertSubErrorCodesToExceptions(true);
         provider.setSearchFilter(filter);
         return provider;
    }
    
}

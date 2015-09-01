package com.github.aha.poc.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import com.github.aha.poc.security.controller.ActionConsts;

@Configuration
@EnableWebSecurity
//@ConditionalOnClass(org.apache.directory.server.core.DefaultDirectoryService.class)
@ConditionalOnProperty(prefix = "auth", name = "type", havingValue = "ACTIVE_DIRECTORY")
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
				.antMatchers(ActionConsts.ROOT, ActionConsts.HOME).permitAll()
				.antMatchers(ActionConsts.ADMIN).access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated().and()
			.formLogin()
				.loginPage(ActionConsts.LOGIN)
				.defaultSuccessUrl(ActionConsts.HOME)
				.permitAll()
				.usernameParameter("username").passwordParameter("password").and()
			.logout()
				.permitAll();

	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		authenticationMgr.ldapAuthentication()
////				.userDnPatterns("samaccountname={0}")
////				.groupSearchBase("DC=to2,DC=to2cz,DC=cz")
////				.contextSource().url("ldap://to2.to2cz.cz:389/");
//		.userDnPatterns("uid={0},ou=people")
//		.groupSearchBase("ou=groups")
//		.contextSource();
		authenticationMgr.authenticationProvider(activeDirectoryLdapAuthenticationProvider()).userDetailsService(userDetailsService());
	}

    @Bean
    public AuthenticationManager authenticationManager() {
         return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
    }
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
         ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(domain, url);
         provider.setUseAuthenticationRequestCredentials(true);
         provider.setConvertSubErrorCodesToExceptions(true);
         provider.setSearchFilter(filter);
         return provider;
    }
    
}

package com.github.aha.poc.security.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdProviderModifier {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdProviderModifier.class);

	/**
	 * Just AOP example (to verify the functionality)
	 */
    @Before("execution(* com.github.aha.poc..*Controller.*(..))")
    public void logLogin(JoinPoint joinPoint) {
    	LOG.info("***** Starting: {} *****", joinPoint.getSignature().getName());
    }

//    @Before("execution(* org.springframework.security.ldap.SpringSecurityLdapTemplate.searchForSingleEntryInternal(..))")
    @Before("execution(* javax.naming.directory.DirContext.search(..))")
    public void modifyAuthParams(JoinPoint joinPoint) {
    	LOG.info("***** Spring template params: {} *****", Arrays.toString(joinPoint.getArgs()));
    	
    	
    	ContextSource cs = null;
    	
    	LdapTemplate lt = new LdapTemplate();
    	lt.setContextSource(cs);
    }

}

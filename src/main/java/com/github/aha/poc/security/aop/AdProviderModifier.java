package com.github.aha.poc.security.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    	LOG.info("Controller method {} called ...", joinPoint.getSignature().getName());
    }

}

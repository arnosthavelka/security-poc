package com.github.aha.poc.security.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ControllerLogger {
	
    @Before("execution(* com.github.aha.poc..*Controller.*(..))")
    public void logLogin(JoinPoint joinPoint) {
		log.info("Controller method {} called ...", joinPoint.getSignature().getName());
    }

}

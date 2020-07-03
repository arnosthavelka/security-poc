package com.github.aha.poc.security.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationListener.class);
	
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		LOG.info("Authenticated user={}", event.getAuthentication().getName());
	}

}

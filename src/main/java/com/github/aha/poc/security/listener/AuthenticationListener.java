package com.github.aha.poc.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthenticationListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		log.info("Authenticated user={}", event.getAuthentication().getName());
	}

}

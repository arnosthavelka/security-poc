package com.github.aha.poc.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SecuredApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Throwable {
		System.setProperty("spring.profiles.default", "IN_MEMORY");
        SpringApplication.run(SecuredApplication.class, args);
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecuredApplication.class);
	}

}

package com.github.aha.poc.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @see http://www.journaldev.com/8748/spring-4-mvc-security-managing-roles-example
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/views/", ".jsp");
//	}	
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("welcomePage");
    	registry.addViewController("/welcome").setViewName("welcomePage");
        registry.addViewController("/home").setViewName("homePage");
        registry.addViewController("/user").setViewName("userPage");
        registry.addViewController("/admin").setViewName("adminPage");
    }
}

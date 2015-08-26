package com.github.aha.poc.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.aha.poc.security.controller.ActionConsts;

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
    	registry.addViewController(ActionConsts.ROOT).setViewName("welcomePage");
    	registry.addViewController(ActionConsts.WELCOME).setViewName("welcomePage");
        registry.addViewController(ActionConsts.HOME).setViewName("homePage");
        registry.addViewController(ActionConsts.USER).setViewName("userPage");
        registry.addViewController(ActionConsts.ADMIN).setViewName("adminPage");
    }
}

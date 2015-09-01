package com.github.aha.poc.security.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.aha.poc.security.controller.ActionConsts;

/**
 * @see http://www.journaldev.com/8748/spring-4-mvc-security-managing-roles-example
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController(ActionConsts.ROOT).setViewName("welcomePage");
    	registry.addViewController(ActionConsts.WELCOME).setViewName("welcomePage");
        registry.addViewController(ActionConsts.HOME).setViewName("homePage");
        registry.addViewController(ActionConsts.ADMIN).setViewName("adminPage");
        registry.addViewController(ActionConsts.ERROR_403).setViewName("error/error403");
    }
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, ActionConsts.ERROR_403));
            }
        };
	}	
}

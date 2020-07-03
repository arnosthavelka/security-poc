package com.github.aha.poc.security.config;

import static com.github.aha.poc.security.controller.ActionConsts.ERROR_403;
import static com.github.aha.poc.security.controller.ActionConsts.HOME;
import static com.github.aha.poc.security.controller.ActionConsts.ROOT;
import static com.github.aha.poc.security.controller.ActionConsts.WELCOME;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * @see http://www.journaldev.com/8748/spring-4-mvc-security-managing-roles-example
 * @see https://www.baeldung.com/embeddedservletcontainercustomizer-configurableembeddedservletcontainer-spring-boot
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(ROOT).setViewName("welcome");
		registry.addViewController(WELCOME).setViewName("welcome");
		registry.addViewController(HOME).setViewName("home");
		registry.addViewController(ERROR_403).setViewName("error403");
    }
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
		return (ConfigurableServletWebServerFactory container) -> container.addErrorPages(new ErrorPage(FORBIDDEN, ERROR_403));
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles/tiles.xml");
		configurer.setCheckRefresh(true);
		return configurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		return new TilesViewResolver();
	}
}

package org.expertdatabase.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/home");
		registry.addViewController("/home").setViewName("/home");
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/wsapi").setViewName("/swagger");
		registry.addViewController("/401").setViewName("/error/page401");
		registry.addViewController("/access-denied").setViewName("/error/page403");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
				.allowedOrigins("*");
	}
}

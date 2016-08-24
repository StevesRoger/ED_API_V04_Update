package org.expertdatabase.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ExpertSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier(value="ajaxAuthenticationSuccessHandler")
	private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
	
	@Autowired
	@Qualifier(value="ajaxAuthenticationFailureHandler")
	private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;
	
	@Autowired
	private UserDetailsService userDetailService;

	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		//auth.inMemoryAuthentication().withUser("admin").password("admin123!@").roles("ADMIN");
		auth.userDetailsService(userDetailService)
		.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
		.authorizeRequests()
		.antMatchers("/wsapi/**").hasAnyRole("ADMIN");
		
		http
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll().failureHandler(ajaxAuthenticationFailureHandler)
		.successHandler(ajaxAuthenticationSuccessHandler);	
		
		
		http.exceptionHandling().accessDeniedPage("/access-denied");*/
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}

package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication
		// Tell Spring Security to use JDBC authentication with our data source
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").hasRole("EMPLOYEE")// ** means all sub directories recursively
				.antMatchers("/leaders/**").hasRole("MANAGER")// restricting access using antmatchers
				.antMatchers("/systems/**").hasRole("ADMIN")
				// .anyRequest().authenticated()// show our custom form at the request mapping
				// "/showMyLoginPage"
		.and().formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")// Login for should POST data to this URL for processing (check used id and passoword)
				.permitAll() // everyone can access this one without log in.
				.and().logout().permitAll()// adds logout support
				.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}

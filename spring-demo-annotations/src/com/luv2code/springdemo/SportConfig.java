package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo") // package to scan
@PropertySource("classpath:sport.properties")
public class SportConfig {
// define bean for our sad fortune service
	@Bean // this method name will be the "bean id" assigned to the container
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		// the reference if of the method we defined above in the bean
		return new SwimCoach(sadFortuneService());
	}
}

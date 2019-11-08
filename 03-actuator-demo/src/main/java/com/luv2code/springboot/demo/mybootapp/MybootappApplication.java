package com.luv2code.springboot.demo.mybootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* the @SpringBootApplication annotation is Composed of following annotations
@EnableAutoConfiguration
@ComponentScan
@Configuration
*/
@SpringBootApplication
public class MybootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootappApplication.class, args);
	}

}

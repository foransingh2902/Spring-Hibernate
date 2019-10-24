package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration // Spring Pure Java Configuration
@EnableAspectJAutoProxy // Spring AOP Proxy Support
@ComponentScan("com.luv2code.aopdemo") // component scan for
// components, beans and aspects. Recurse packages
public class DemoConfig {

}

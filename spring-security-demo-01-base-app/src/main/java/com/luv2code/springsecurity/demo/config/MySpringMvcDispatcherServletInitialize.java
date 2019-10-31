package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {
	/*
	 * Implementations are required to implement:
	 * 
	 * getRootConfigClasses() -- for "root" application context (non-web
	 * infrastructure) configuration. getServletConfigClasses() -- for
	 * DispatcherServlet application context (Spring MVC infrastructure)
	 * configuration. public abstract class
	 * AbstractAnnotationConfigDispatcherServletInitializer extends
	 * AbstractDispatcherServletInitializer AbstractDispatcherServletInitializer
	 * gives the method getServletMappings
	 */

	/*
	 * DispatcherServlet is Spring MVC's implementation of the front controller
	 * pattern. Essentially, it's a servlet that takes the incoming request, and
	 * delegates processing of that request to one of a number of handlers, the
	 * mapping of which is specific in the DispatcherServlet configuration
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// no root config classes for our project... only servlet config classes
		/*
		 * Root Config Classes are actually used to Create Beans which are Application
		 * Specific and which needs to be available for Filters (As Filters are not part
		 * of Servlet). Servlet Config Classes are actually used to Create Beans which
		 * are DispatcherServlet specific such as ViewResolvers, ArgumentResolvers,
		 * Interceptor, etc
		 */
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// passing Servlet config class that we created earlier
		return new Class[] { DemoAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

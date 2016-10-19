package com.kasisripriyawebapps.myindia.configs;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@SuppressWarnings("deprecation")
@Component
public class JerseyConfig extends ResourceConfig {

	@Autowired
	private Environment env;

	public JerseyConfig() {
		register(RequestContextFilter.class);
		register(AuthenticationRequestFilter.class);
		packages("com.kasisripriyawebapps.myindia.endpoints", "com.kasisripriyawebapps.myindia.exception");
		register(LoggingFilter.class);
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void configureSwagger() {

		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setTitle(env.getProperty("app.description"));
		config.setVersion(env.getProperty("app.api-version"));
		config.setContact(env.getProperty("app.contact"));
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath(env.getProperty("spring.jersey.application-path"));
		config.setResourcePackage(env.getProperty("spring.jersey.package-scan"));
		config.setPrettyPrint(true);
		config.setScan(true);
	}
}

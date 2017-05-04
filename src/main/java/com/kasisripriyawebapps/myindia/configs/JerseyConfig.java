package com.kasisripriyawebapps.myindia.configs;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

	@Autowired
	private Environment env;

	public JerseyConfig() {
		register(RequestContextFilter.class);
		packages("com.kasisripriyawebapps.myindia.endpoints", "com.kasisripriyawebapps.myindia.exception");
		 //scan(new
		 //String[]{"com.kasisripriyawebapps.myindia.endpoints","com.kasisripriyawebapps.myindia.exception"});

		register(LoggingFilter.class);
		register(MultiPartFeature.class);

	}

	public void scan(String... packages) {
		for (String pack : packages) {
			Reflections reflections = new Reflections(pack);
			reflections.getTypesAnnotatedWith(Provider.class).parallelStream().forEach((clazz) -> {
				register(clazz);
			});
			reflections.getTypesAnnotatedWith(Path.class).parallelStream().forEach((clazz) -> {
				register(clazz);
			});
		}
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

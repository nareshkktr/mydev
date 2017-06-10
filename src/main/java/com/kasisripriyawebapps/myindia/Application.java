package com.kasisripriyawebapps.myindia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication(scanBasePackages = { "com.kasisripriyawebapps.myindia" })
@PropertySources({ @PropertySource(value = { "classpath:sarpanchexport.coordinates", "application.properties" }) })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

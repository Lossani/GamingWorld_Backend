package com.gamingworld.app.gamingworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GamingworldApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GamingworldApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GamingworldApplication.class);
	}

}

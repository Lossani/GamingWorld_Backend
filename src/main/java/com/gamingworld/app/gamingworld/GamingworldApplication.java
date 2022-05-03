package com.gamingworld.app.gamingworld;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamingworldApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GamingworldApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GamingworldApplication.class);
	}

	@Bean
	public OpenAPI gamingworldAPIDocumentation() {
		return new OpenAPI()
				.addServersItem(new Server().url("https:/api.gworld.xempre.com"))
				.info(new Info().title("RESTFul API Documentation")
						.description("Documentation for all GamingWorld RESTFul API Endpoints.")
						.version("v3.0.0"));
	}
}


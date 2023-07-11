package com.huongdanjava.springboot;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SpringBootSpringdocOpenapiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringdocOpenapiExampleApplication.class, args);
	}

	@Bean
	GroupedOpenApi studentApi() {
	  return GroupedOpenApi.builder()
	      .group("Huong Dan Java")
	      .packagesToScan("com.huongdanjava.springboot")
	      .pathsToMatch("/student/*")
	      .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Student API")))
	      .build();
	}

}

package com.huongdanjava.springbootspringfox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwaggerApplication {

	@Bean
	public Docket studentAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.huongdanjava.springbootspringfox"))
			.paths(PathSelectors.regex("/student.*"))
			.build()
			.apiInfo(metaData());
	}

	private ApiInfo metaData() {
        return new ApiInfoBuilder()
        		.title("Spring Boot Swagger")
            .description("An example about Spring Boot and Springfox for Swagger.")
            .contact(new Contact("Huong Dan Java", "huongdanjava.com", "huongdanjava.com@gmail.com"))
            .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}
}

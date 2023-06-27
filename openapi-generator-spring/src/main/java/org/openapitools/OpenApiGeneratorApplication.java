package org.openapitools;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.Module;

//@SpringBootApplication(
//    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
//)
//@ComponentScan(
//    basePackages = {"org.openapitools", "com.huongdanjava.openapispring.web" , "org.openapitools.configuration"},
//    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
//)
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean(name = "org.openapitools.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
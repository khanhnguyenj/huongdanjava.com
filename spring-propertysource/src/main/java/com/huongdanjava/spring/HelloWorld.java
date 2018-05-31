package com.huongdanjava.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources ({
	@PropertySource(value = "classpath:configuration.properties", ignoreResourceNotFound = true),
	@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true)
})
public class HelloWorld {

	@Value("${app.author}")
    private String name;

    public void print()  {
        System.out.print("Hello, " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.huongdanjava.springaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Clazz implements ApplicationContextAware, BeanNameAware {

	private String name;
	private ApplicationContext context;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setBeanName(String name) {
		this.name = name;
	}

}
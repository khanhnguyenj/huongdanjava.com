package com.huongdanjava.spring;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class HDJBeanRegistrar implements BeanRegistrar {

  @Override
  public void register(BeanRegistry registry, Environment env) {
    registry.registerBean(Hello.class);

    registry.registerBean("huongdanjava_hello", Hello.class);

    if (env.matchesProfiles("dev")) {
      registry.registerBean("huongdanjava_hello_dev", Hello.class);
    }
  }
}

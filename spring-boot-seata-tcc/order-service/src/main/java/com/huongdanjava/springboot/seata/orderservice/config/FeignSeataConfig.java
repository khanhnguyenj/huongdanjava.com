package com.huongdanjava.springboot.seata.orderservice.config;

import feign.RequestInterceptor;
import org.apache.seata.core.context.RootContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSeataConfig {
  @Bean
  public RequestInterceptor seataFeignInterceptor() {
    return requestTemplate -> {
      String xid = RootContext.getXID();
      if (xid != null) {
        requestTemplate.header(RootContext.KEY_XID, xid);
      }
    };
  }
}
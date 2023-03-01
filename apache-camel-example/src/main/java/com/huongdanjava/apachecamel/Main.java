package com.huongdanjava.apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

  public static void main(String[] args) throws Exception {
    try (CamelContext camelContext = new DefaultCamelContext();) {

      RouteBuilder routeBuilder = new RouteBuilder() {

        @Override
        public void configure() throws Exception {
          // @formatter:off
          from("scheduler://hdj?delay=5000")
              .setBody(simple("Hello Khanh from Huong Dan Java"))
              .to("log:com.huongdanjava.apachecamel?showAll=true&multiline=true");
          // @formatter:on
        }
      };
      camelContext.addRoutes(routeBuilder);

      camelContext.start();
      Thread.sleep(100000);
      camelContext.stop();
    }
  }

}

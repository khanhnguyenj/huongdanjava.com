package com.huongdanjava.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Example {

  private static Logger LOGGER = LoggerFactory.getLogger(Example.class);

  public static void main(String[] args) {
    LOGGER.info("An example with Mapped Diagnostic Context");

    String user = "Khanh";
    MDC.put("user", user);
    LOGGER.info(": Messsage 1");
    LOGGER.info(": Messsage 2");
    LOGGER.info(": Messsage 3");

    user = "Quan";
    MDC.put("user", user);
    LOGGER.info(": Messsage 1");
    LOGGER.info(": Messsage 2");
    LOGGER.info(": Messsage 3");
  }

}

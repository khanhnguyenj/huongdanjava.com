package com.huongdanjava.jaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HelloResource {

  @GET
  @Path("hello")
  public String hello() {
    return "Hello World!";
  }
}

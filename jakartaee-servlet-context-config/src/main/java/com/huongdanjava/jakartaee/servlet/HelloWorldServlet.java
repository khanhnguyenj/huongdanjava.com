package com.huongdanjava.jakartaee.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    // Writing the message on the web page
    PrintWriter out = resp.getWriter();
    out.println("Hello Servlet");

    ServletConfig servletConfig = getServletConfig();
    out.println(servletConfig.getInitParameter("name"));
    out.println(servletConfig.getInitParameter("website"));
  }
}

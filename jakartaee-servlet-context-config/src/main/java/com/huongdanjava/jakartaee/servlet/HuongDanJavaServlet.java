package com.huongdanjava.jakartaee.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HuongDanJavaServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    // Writing the message on the web page
    PrintWriter out = resp.getWriter();
    out.println("Huong Dan Java Servlet");

    ServletContext servletContext = getServletContext();
    out.println(servletContext.getInitParameter("name"));
    out.println(servletContext.getInitParameter("website"));
  }
}

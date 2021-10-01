package com.huongdanjava.jakartaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Setting up the content type of web page
    resp.setContentType("text/html");

    // Writing the message on the web page
    PrintWriter out = resp.getWriter();
    out.println("<h1>Hello World from Huong Dan Java</h1>");
  }
}

package com.huongdanjava.jakartaee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    TemplateEngine templateEngine = (TemplateEngine) getServletContext().getAttribute(
        ThymeleafConfiguration.TEMPLATE_ENGINE_ATTR);

    IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext())
        .buildExchange(req, resp);

    WebContext context = new WebContext(webExchange);

    context.setVariable("name", "Huong Dan Java");

    templateEngine.process("home", context, resp.getWriter());
  }
}

package com.huongdanjava.jakartaee.servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebListener
public class ThymeleafConfiguration implements ServletContextListener {

  public static final String TEMPLATE_ENGINE_ATTR = "com.huongdanjava.thymeleaf.TemplateEngineInstance";

  private ITemplateEngine templateEngine;

  private JakartaServletWebApplication application;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    this.application =
        JakartaServletWebApplication.buildApplication(sce.getServletContext());
    this.templateEngine = templateEngine(this.application);

    sce.getServletContext().setAttribute(TEMPLATE_ENGINE_ATTR, templateEngine);
  }

  private ITemplateEngine templateEngine(IWebApplication application) {
    TemplateEngine templateEngine = new TemplateEngine();

    WebApplicationTemplateResolver templateResolver = templateResolver(
        application);
    templateEngine.setTemplateResolver(templateResolver);

    return templateEngine;
  }

  private WebApplicationTemplateResolver templateResolver(
      IWebApplication application) {
    WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(
        application);

    // HTML is the default mode, but we will set it anyway for better understanding of code
    templateResolver.setTemplateMode(TemplateMode.HTML);
    // This will convert "home" to "/WEB-INF/templates/home.html"
    templateResolver.setPrefix("/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    // Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
    templateResolver.setCacheTTLMs(Long.valueOf(3600000L));

    // Cache is set to true by default. Set to false if you want templates to be automatically updated when modified.
    templateResolver.setCacheable(true);

    return templateResolver;
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // NOP
  }
}

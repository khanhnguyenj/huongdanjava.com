package com.huongdanjava.socketio;

import java.net.InetSocketAddress;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Application {

  public static void main(String[] args) {
    Server server = new Server(new InetSocketAddress("localhost", 8080));

    ServletContextHandler servletContextHandler =
        new ServletContextHandler(ServletContextHandler.SESSIONS);
  }

}

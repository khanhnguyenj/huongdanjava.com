package com.huongdanjava.socketio;

import java.io.IOException;
import java.net.InetSocketAddress;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoServerOptions;
import io.socket.socketio.server.SocketIoServer;

public class Application {

  public static void main(String[] args) {
    // Init SocketIoServer
    EngineIoServerOptions engineIoServerOptions = EngineIoServerOptions.newFromDefault();
    EngineIoServer engineIoServer = new EngineIoServer(engineIoServerOptions);
    SocketIoServer socketIoServer = new SocketIoServer(engineIoServer);

    // Start Embedded Jetty Server
    Server server = new Server(new InetSocketAddress("localhost", 8080));

    ServletContextHandler servletContextHandler =
        new ServletContextHandler(ServletContextHandler.SESSIONS);

    servletContextHandler.addServlet(new ServletHolder(new HttpServlet() {
      @Override
      protected void service(HttpServletRequest request, HttpServletResponse response)
          throws IOException {
        engineIoServer.handleRequest(new HttpServletRequestWrapper(request) {
          @Override
          public boolean isAsyncSupported() {
            return false;
          }
        }, response);
      }
    }), "/socket.io/*");
  }

}

package com.huongdanjava.socketio;

import java.io.IOException;
import java.net.InetSocketAddress;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.pathmap.ServletPathSpec;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter;
import io.socket.emitter.Emitter;
import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoServerOptions;
import io.socket.engineio.server.JettyWebSocketHandler;
import io.socket.socketio.server.SocketIoNamespace;
import io.socket.socketio.server.SocketIoServer;
import io.socket.socketio.server.SocketIoSocket;

public class Application {

  public static void main(String[] args) throws Exception {
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
        engineIoServer.handleRequest(request, response);
      }
    }), "/socket.io/*");

    WebSocketUpgradeFilter webSocketUpgradeFilter =
        WebSocketUpgradeFilter.configureContext(servletContextHandler);
    webSocketUpgradeFilter.addMapping(new ServletPathSpec("/socket.io/*"), (servletUpgradeRequest,
        servletUpgradeResponse) -> new JettyWebSocketHandler(engineIoServer));

    server.setHandler(servletContextHandler);

    server.start();

    SocketIoNamespace ns = socketIoServer.namespace("/");
    ns.on("connection", new Emitter.Listener() {
      @Override
      public void call(Object... args) {
        SocketIoSocket socket = (SocketIoSocket) args[0];
        System.out.println("Client " + socket.getId() + " has connected.");

        // ns.emit("hello", "Hello World");
      }
    });

    ns.on("message", new Emitter.Listener() {
      @Override
      public void call(Object... args) {
        System.out.println(args[0]);
      }
    });
  }

}

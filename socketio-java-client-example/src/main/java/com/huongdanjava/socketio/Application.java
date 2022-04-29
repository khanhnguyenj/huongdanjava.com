package com.huongdanjava.socketio;

import java.net.URI;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Application {

  public static void main(String[] args) {
    URI uri = URI.create("http://localhost:8080");

    // @formatter:off
    IO.Options options = IO.Options.builder()
        .build();
    // @formatter:on

    Socket socket = IO.socket(uri, options);

    socket.connect();

    socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
      @Override
      public void call(Object... args) {
        System.out.println("Connected to server");
      }
    });

    socket.emit("message", "Hello World");

    socket.on("hello", new Emitter.Listener() {
      @Override
      public void call(Object... args) {
        System.out.println(args[0]);
      }
    });
  }

}

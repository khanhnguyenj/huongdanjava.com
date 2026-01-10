package com.huongdanjava.apache.jackrabbitoak;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import org.apache.jackrabbit.oak.Oak;
import org.apache.jackrabbit.oak.jcr.Jcr;
import org.apache.jackrabbit.oak.security.SecurityProviderImpl;
import org.apache.jackrabbit.oak.spi.security.SecurityProvider;

public class Application {

  static void main() throws RepositoryException {
    Oak oak = new Oak();
    Jcr jcr = new Jcr(oak);

    SecurityProvider securityProvider = new SecurityProviderImpl();

    Repository repository = jcr
        .with(securityProvider)
        .createRepository();

    // Login
    Session session = repository.login(
        new SimpleCredentials("admin", "admin".toCharArray())
    );

    // Create a node
    Node root = session.getRootNode();
    Node hello = root.addNode("hello");
    hello.setProperty("message", "Hello from Huong Dan Java!");
    hello.setProperty("author", "Khanh Nguyen");

    hello.addNode("hello_child").setProperty("desc", "Hello Child");

    session.save();

    // Read node
    Node readNode = session.getRootNode().getNode("hello");

    System.out.println(readNode.getProperty("message").getString());

    System.out.println(readNode.getNode("hello_child").getProperty("desc").getString());

    session.logout();
  }

}

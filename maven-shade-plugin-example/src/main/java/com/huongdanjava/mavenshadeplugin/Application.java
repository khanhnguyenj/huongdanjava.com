package com.huongdanjava.mavenshadeplugin;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.lang3.StringUtils;

public class Application {

  public static void main(String[] args) throws IOException {
    String version = getVersion();

    System.out.println(StringUtils
        .capitalize("hello from Huong Dan Java. Application version is " + version));
  }

  private static String getVersion() throws IOException {
    URLClassLoader cl = (URLClassLoader) Application.class.getClassLoader();
    URL url = cl.findResource("META-INF/MANIFEST.MF");
    Manifest manifest = new Manifest(url.openStream());
    Attributes attr = manifest.getMainAttributes();

    return attr.getValue("Implementation-Version");
  }
}

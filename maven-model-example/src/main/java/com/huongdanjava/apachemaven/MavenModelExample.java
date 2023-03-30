package com.huongdanjava.apachemaven;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class MavenModelExample {

  public static void main(String[] args) throws IOException, XmlPullParserException {
    String pomXml = "/Users/khanh/Documents/code/huongdanjava.com/spring-boot-actuator/pom.xml";
    Reader reader = new FileReader(pomXml);

    MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
    Model model = xpp3Reader.read(reader);

    List<Plugin> plugins = model.getBuild().getPlugins();
    plugins.forEach(p -> System.out.println(p.getArtifactId()));
  }

}

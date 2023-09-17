package com.huongdanjava.commonconfiguration;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ConfigurationConverter;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Application {

  public static void main(String[] args) throws ConfigurationException {
    Path path = Paths.get("src", "main", "resources", "config.properties");

    FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<>(
        PropertiesConfiguration.class);

    Parameters parameters = new Parameters();
    builder.configure(parameters.properties().setFile(path.toFile()));

    Configuration configuration = builder.getConfiguration();

    Properties properties = ConfigurationConverter.getProperties(configuration);

    System.out.println(properties.getProperty("huongdanjava.introduction.url"));
  }
}

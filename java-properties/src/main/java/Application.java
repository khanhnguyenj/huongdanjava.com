import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Application {

  public static void main(String[] args) throws IOException {
    Properties properties = new Properties();

    Path path = Paths.get("src", "main", "resources", "config.properties");
    try (InputStream inputStream = new FileInputStream(path.toFile())) {
      properties.load(inputStream);
    }

    properties.remove("env");

    System.out.println(properties.getProperty("env"));
  }
}

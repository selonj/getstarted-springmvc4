import com.selonj.supports.Application;
import com.selonj.supports.ApplicationDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by L.x on 16-2-18.
 */
public class SpringMvcTest {
  private Application application = new Application();
  private ApplicationDriver driver = new ApplicationDriver(application);

  @Before
  public void start() throws Exception {
    application.start();
  }

  @Test
  public void ping() throws Exception {
    driver.get("/");

    driver.hasSentMessageContaining("Get Started Spring Mvc4");
  }

  @Test
  public void echo() throws Exception {
    driver.get("/echo?username=Dove");

    driver.hasSentMessageContaining("{\"username\":\"Dove\"}");
  }

  @Test public void classpathResource() throws Exception {
    driver.get("/resources/classpath/index.html");

    driver.hasSentMessageContaining("Classpath Resource");
  }

  @Test public void fileSystemResources() throws Exception {
    driver.get("/resources/filesystem/index.html");

    driver.hasSentMessageContaining("File System Resource");
  }

  @After
  public void stop() throws Exception {
    application.stop();
    driver.close();
  }
}

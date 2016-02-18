import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by L.x on 16-2-18.
 */
public class SpringMvcTest {
    private Application application=new Application();

    @Before
    public void start() throws Exception {
        application.start();
    }

    @Test
    public void startApplication() throws Exception {
        application.get("/");

        application.hasSentMessageContaining("Get Started Spring Mvc4");
    }

    @After
    public void stop() throws Exception {
        application.stop();
    }
}

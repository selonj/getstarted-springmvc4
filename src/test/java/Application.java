import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

import java.io.IOException;

/**
 * Created by L.x on 16-2-18.
 */
public class Application {
    public static final int SERVER_PORT = 80;
    public static final String WEB_APP_DIR = "src/main/webapp";
    private Server server;
    private HtmlPage page;

    public Application() {
        server=new Server(SERVER_PORT);
        server.setStopAtShutdown(true);
        server.setHandler(new WebAppContext(){{
            setWar(WEB_APP_DIR);
        }});
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public void get(String url) throws IOException {
        WebClient client=new WebClient();
        page = client.getPage("http://localhost"+url);
    }

    public void hasSentMessageContaining(String pieceOfContent) {
        WebAssert.assertTextPresent(page,pieceOfContent);
    }
}

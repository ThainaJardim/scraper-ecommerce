import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Scraper {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);
        context.addServlet(new ServletHolder(new RequestServlet()), "/*");
        context.addServlet(new ServletHolder(new RequestServlet()), "/sephora*");



        server.start();
        server.join();
    }
}

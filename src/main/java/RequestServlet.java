import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class RequestServlet extends HttpServlet {

    ProductHandler productHandler = new ProductHandler();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("charset=utf-8");
        String url = getRequestBody(request);
        final Document document = Jsoup.connect(url).get();
        productHandler.recebeInfoProduc(document);
        productHandler.showProductInfo();
        response.getWriter().println(productHandler.showProductInfo());
        System.out.println(productHandler.showProductInfo());
    }


    public String getRequestBody(HttpServletRequest req) {
        try (BufferedReader br = req.getReader()) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            return "";
        }
    }

}

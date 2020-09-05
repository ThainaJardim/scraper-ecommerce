import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.Scanner;

public class Scraper {

    public static void main(String[] args) throws Exception{

        System.out.println("Qual a url?");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.next();

        final Document document = Jsoup.connect(url).get();

        ProductHandler ecommerce;

        ecommerce = new ProductHandler();

        ecommerce.getProductInfo(document);

        ecommerce.showProductInfo();
    }
}

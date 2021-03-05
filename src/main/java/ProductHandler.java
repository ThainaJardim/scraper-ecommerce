import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductHandler {

    protected String nome;
    protected String preco;

    public void recebeInfoProduc(Document doc){
        nome = getNome(doc);
        preco = getPreco(doc);
    }

    public String getNome(Document docX){
        Elements tags = docX.select(".product-name-small");
        Element tag = tags.first();
        return tag.text();
    }

    public String getPreco(Document docA) {
        Elements tags = docA.select (".price-sales span");
        String tag = tags.first().toString();
        return tag.split("\\$")[1].replaceAll("</span>", "");

    }

    public String showProductInfo() {
        return "O produto "  + this.nome + " custa R$ " + this.preco;
    }
}

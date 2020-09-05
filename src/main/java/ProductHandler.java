import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductHandler {

    protected String nome;
    protected Float preco;

    public void getProductInfo(Document doc){
        nome = getNome(doc);
        preco = getPreco(doc);
    }

    public String getNome(Document docX){
        String nome;
        Elements tags = docX.select("#product_addtocart_form > div.product-shop > div.product-name > h1");
        Element tag = tags.first();
        nome = tag.text();
        return nome;
    }

    public Float getPreco(Document docA) {
        Elements tags = docA.select ("#product_addtocart_form > div.add-to-cart-wrapper > div.price-info-grouped > div.selected-info > div.final-price > span");
        Element tag = tags.first();
        try {
            preco = Float.valueOf(tag.text());
        } catch (Exception e) {
            preco = 0f;
        }
        return preco;
    }

    public void showProductInfo() {
        System.out.printf("O produto %s custa R$ %4.2f", this.nome, this.preco);
    }
}

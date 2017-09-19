package sj11.priceBasket.till;

import java.util.List;
import java.util.Objects;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;

public class Till {

    private Printer printer;
    private ProductProvider productProvider;
    private static final String CONFIG_PACKAGE = "sj11.priceBasket.config";

    public Till() {
        this.printer = new Printer();
        getProductProviderFromContext();
    }

    public void charge(String[] shoppingItems) {
        Product product = new Product("Apple", 1.4f, false);
        Product productSaved = productProvider.save(product);
        System.out.println("******" +productSaved);
        List<Product> allProducts = productProvider.getAllProducts();
        System.out.println(allProducts.get(0));
        //validate input (name -> Product)
        //Scan all items
        //Apply discounts
        //Print
    }

    private void applyDiscounts(Ticket ticket) {
    }

    private void getProductProviderFromContext() {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			ctx.scan(CONFIG_PACKAGE);
			ctx.refresh();
			productProvider = ctx.getBean(ProductProvider.class);
            Product product = new Product("Peach", 1.2f, false);
            productProvider.save(product);
		}
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.printer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Till other = (Till) obj;
        if (!Objects.equals(this.printer, other.printer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Till{" + "printer=" + printer + '}';
    }
}

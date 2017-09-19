package sj11.priceBasket.till;

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
        getProductProviderFromSpringContext();
    }

    public void charge(String[] shoppingItems) {
        Ticket ticket = validate(shoppingItems);
        scan(ticket);
        applyDiscounts(ticket);
        printer.print(ticket);
    }

    private Ticket validate(String[] shoppingItems) {
        Ticket ticket = new Ticket();
        for (String item : shoppingItems) {
            ticket.getShoppingList().add(validate(item));
        }
        return ticket;
    }

    private Product validate(String productName) {
        return productProvider.validate(productName);
    }

    private void scan(Ticket ticket) {
        ticket.getShoppingList().forEach(product -> {
            ticket.addToSubtotal(product.getPriceInPounds());
        });
    }

    private void applyDiscounts(Ticket ticket) {
    }

    private void getProductProviderFromSpringContext() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan(CONFIG_PACKAGE);
        ctx.refresh();
        productProvider = ctx.getBean(ProductProvider.class);
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

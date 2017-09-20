package sj11.priceBasket.till;

import sj11.priceBasket.services.ProductService;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;

public class Scanner {

    private final ProductService productService;

    public Scanner(ProductService productService) {
        this.productService = productService;
    }

    public Ticket validate(String[] shoppingItems) {
        Ticket ticket = new Ticket();
        for (String item : shoppingItems) {
            ticket.getShoppingList().add(validate(item));
        }
        return ticket;
    }

    public void scan(Ticket ticket) {
        ticket.getShoppingList().forEach(product -> {
            ticket.addToSubtotal(product.getPriceInPounds());
        });
    }

    private Product validate(String productName) {
        return productService.validate(productName);
    }
}

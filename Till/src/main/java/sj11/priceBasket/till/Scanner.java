package sj11.priceBasket.till;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sj11.priceBasket.services.ProductService;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;

@Component
public class Scanner {

    @Autowired
    private ProductService productService;

    public Ticket scan(String[] shoppingItems) throws NoSuchElementException {
        Ticket ticket = new Ticket();
        for (String item : shoppingItems) {
            Product productFromDb = validate(item);
            if (productFromDb != null) {
                ticket.getShoppingList().add(productFromDb);
                ticket.addToSubtotal(productFromDb.getPriceInPounds());
            } else {
                throw new NoSuchElementException("The product does not exist");
            }
        }
        return ticket;
    }

    private Product validate(String productName) {
        return productService.validate(productName);
    }
}

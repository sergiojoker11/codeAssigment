package sj11.priceBasket.till;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sj11.priceBasket.entities.Discount;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;
import sj11.priceBasket.exceptions.InvalidDiscountAppliedException;
import sj11.priceBasket.services.DiscountService;

@Component
public class DiscountApplier {

    @Autowired
    private DiscountService discountService;

    public void applyDiscounts(Ticket ticket) throws InvalidDiscountAppliedException {
        Set<Discount> discountList = discountService.getAll();
        for (Discount discount:discountList) {
            applyDiscount(ticket, discount);
        }
        ticket.calculateTotal();
    }

    private void applyDiscount(Ticket ticket, Discount discount) throws InvalidDiscountAppliedException {
        Set<Product> productsToApply = discount.getDiscountToApply().getProducts();
        if (ticket.getShoppingList().containsAll(productsToApply)) {
            ticket.addDiscount(discount.getDiscountApplied());
            ticket.getShoppingList().removeAll(productsToApply);
        }
    }
}
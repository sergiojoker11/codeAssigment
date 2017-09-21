package sj11.priceBasket.till;

import java.util.Set;
import sj11.priceBasket.entities.Discount;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;
import sj11.priceBasket.services.DiscountService;

public class DiscountApplier {

    private final DiscountService discountService;
    Set<Discount> discountList;

    public DiscountApplier(DiscountService discountService) {
        this.discountService = discountService;
        this.discountList = discountService.getAll();
    }

    public void applyDiscounts(Ticket ticket) {
        discountList
                .forEach((discount) -> {
                    applyDiscount(ticket, discount);
                });
        ticket.calculateTotal();
    }

    private void applyDiscount(Ticket ticket, Discount discount) {
        Set<Product> productsToApply = discount.getDiscountToApply().getProducts();
        if (ticket.getShoppingList().containsAll(productsToApply)) {
            ticket.addDiscount(discount.getDiscountApplied());
            ticket.getShoppingList().removeAll(productsToApply);
        }
    }
}

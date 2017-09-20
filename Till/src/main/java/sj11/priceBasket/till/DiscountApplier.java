package sj11.priceBasket.till;

import sj11.priceBasket.entities.Ticket;
import sj11.priceBasket.services.DiscountService;

public class DiscountApplier {

    private DiscountService discountService;

    public DiscountApplier(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void applyDiscounts(Ticket ticket) {
    }
}

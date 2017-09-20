package sj11.priceBasket.till;

import java.util.List;
import sj11.priceBasket.entities.Discount;
import sj11.priceBasket.entities.Ticket;
import sj11.priceBasket.services.DiscountService;

public class DiscountApplier {

    private DiscountService discountService;

    public DiscountApplier(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void applyDiscounts(Ticket ticket) {
        List<Discount> all = discountService.getAll();
        System.out.println(all);
    }
}

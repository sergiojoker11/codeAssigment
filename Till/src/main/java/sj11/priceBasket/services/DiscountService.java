package sj11.priceBasket.services;

import org.springframework.beans.factory.annotation.Autowired;
import sj11.priceBasket.entities.Discount;
import sj11.priceBasket.repositories.DiscountRepository;

public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }
}

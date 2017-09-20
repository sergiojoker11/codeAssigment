package sj11.priceBasket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sj11.priceBasket.entities.Discount;
import sj11.priceBasket.repositories.DiscountRepository;

public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    public List<Discount> getAll() {
        return discountRepository.findAll();
    }
}

package sj11.priceBasket.repositories;

import java.util.List;
import org.springframework.data.repository.Repository;
import sj11.priceBasket.entities.Discount;

public interface DiscountRepository extends Repository<Discount, Long> {

    List<Discount> findAll();

    Discount save(Discount discount);
}

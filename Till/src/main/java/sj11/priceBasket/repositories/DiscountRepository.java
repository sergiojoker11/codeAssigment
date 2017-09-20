package sj11.priceBasket.repositories;

import org.springframework.data.repository.Repository;
import sj11.priceBasket.entities.Discount;

/**
 *
 * @author SeRGiO11
 */
public interface DiscountRepository extends Repository<Discount, Long> {

    Discount save(Discount discount);
}

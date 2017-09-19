package sj11.priceBasket.till;

import org.springframework.beans.factory.annotation.Autowired;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.repositories.ProductRepository;

public class ProductProvider {

    @Autowired
    ProductRepository productRepository;

    public Product validate(String productName) {
        return productRepository.findByName(productName);
    }
}

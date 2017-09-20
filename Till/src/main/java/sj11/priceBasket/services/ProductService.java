package sj11.priceBasket.services;

import org.springframework.beans.factory.annotation.Autowired;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.repositories.ProductRepository;

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product validate(String productName) {
        return productRepository.findByName(productName);
    }
}

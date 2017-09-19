package sj11.priceBasket.till;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.repositories.ProductRepository;

public class ProductProvider {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    Product save(Product product) {
        return productRepository.save(product);
    }
}

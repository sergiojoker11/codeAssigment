package sj11.priceBasket.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiscountApplied implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<Product> productsWithDiscountApplied = new ArrayList<>();

    public DiscountApplied() {
    }

    public DiscountApplied(List<Product> productsWithDiscountApplied) {
        this.productsWithDiscountApplied = productsWithDiscountApplied;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductsWithDiscountApplied() {
        return productsWithDiscountApplied;
    }

    public void setProductsWithDiscountApplied(List<Product> productsWithDiscountApplied) {
        this.productsWithDiscountApplied = productsWithDiscountApplied;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.productsWithDiscountApplied);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiscountApplied other = (DiscountApplied) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.productsWithDiscountApplied, other.productsWithDiscountApplied);
    }

    @Override
    public String toString() {
        return "DiscountApplied{" + "id=" + id + ", productsWithDiscountApplied=" + productsWithDiscountApplied + '}';
    }
}

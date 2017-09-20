package sj11.priceBasket.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiscountToApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<Product> productsToApplyDiscount = new ArrayList<>();

    public DiscountToApply() {
    }

    public DiscountToApply(List<Product> productsToApplyDiscount) {
        this.productsToApplyDiscount = productsToApplyDiscount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductsToApplyDiscount() {
        return productsToApplyDiscount;
    }

    public void setProductsToApplyDiscount(List<Product> productsToApplyDiscount) {
        this.productsToApplyDiscount = productsToApplyDiscount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.productsToApplyDiscount);
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
        final DiscountToApply other = (DiscountToApply) obj;
        return listEqualsNoOrder(this.productsToApplyDiscount, other.productsToApplyDiscount);
    }

    public static <T> boolean listEqualsNoOrder(List<T> l1, List<T> l2) {
        final Set<T> s1 = new HashSet<>(l1);
        final Set<T> s2 = new HashSet<>(l2);

        return s1.equals(s2);
    }

    @Override
    public String toString() {
        return "DiscountToApply{" + "productsToApplyDiscount=" + productsToApplyDiscount + '}';
    }

}

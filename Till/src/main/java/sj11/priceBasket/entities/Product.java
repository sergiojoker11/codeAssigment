package sj11.priceBasket.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "products")
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float priceInPounds;
    private boolean offerApplied;

    public Product(String name, float priceInPounds, boolean offerApplied) {
        this.name = name;
        this.priceInPounds = priceInPounds;
        this.offerApplied = offerApplied;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPriceInPounds() {
        return priceInPounds;
    }

    public void setPriceInPounds(float priceInPounds) {
        this.priceInPounds = priceInPounds;
    }

    public boolean isOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(boolean offerApplied) {
        this.offerApplied = offerApplied;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Float.floatToIntBits(this.priceInPounds);
        hash = 97 * hash + (this.offerApplied ? 1 : 0);
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
        final Product other = (Product) obj;
        if (Float.floatToIntBits(this.priceInPounds) != Float.floatToIntBits(other.priceInPounds)) {
            return false;
        }
        if (this.offerApplied != other.offerApplied) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", priceInPounds=" + priceInPounds + ", offerApplied=" + offerApplied + '}';
    }
}

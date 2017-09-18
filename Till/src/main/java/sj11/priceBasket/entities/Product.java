package sj11.priceBasket.entities;

import java.util.Objects;

public class Product {

    private String name;
    private float priceInPounds;
    private boolean offerApplied;

    public Product(String name, float priceInPounds, boolean offerApplied) {
        this.name = name;
        this.priceInPounds = priceInPounds;
        this.offerApplied = offerApplied;
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
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Float.floatToIntBits(this.priceInPounds);
        hash = 89 * hash + (this.offerApplied ? 1 : 0);
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
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", priceInPounds=" + priceInPounds + ", offerApplied=" + offerApplied + '}';
    }
}

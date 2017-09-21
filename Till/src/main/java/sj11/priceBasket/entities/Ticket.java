package sj11.priceBasket.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ticket {

    private Set<Product> shoppingList;
    private float subtotalInPounds;
    private Set<Discount> discountsApplied;
    private float totalInPounds;

    public Ticket() {
        shoppingList = new HashSet<>();
        discountsApplied = new HashSet<>();
    }

    public void addToSubtotal(float productoPrice) {
        subtotalInPounds += productoPrice;
    }

    public void addDiscount(Discount discount) {
        discountsApplied.add(discount);
    }

    public void processDiscounts() {
        discountsApplied
                .forEach((discount) -> {
                    processDiscount(discount);
                });
    }

    private void processDiscount(Discount discount) {
        Set<Product> products = discount.getDiscountToApply().getProducts();
    }

    public Set<Product> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Set<Product> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public float getSubtotalInPounds() {
        return subtotalInPounds;
    }

    public void setSubtotalInPounds(float subtotalInPounds) {
        this.subtotalInPounds = subtotalInPounds;
    }

    public Set<Discount> getDiscountsApplied() {
        return discountsApplied;
    }

    public void setDiscountsApplied(Set<Discount> discountsApplied) {
        this.discountsApplied = discountsApplied;
    }

    public float getTotalInPounds() {
        return totalInPounds;
    }

    public void setTotalInPounds(float totalInPounds) {
        this.totalInPounds = totalInPounds;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.shoppingList);
        hash = 83 * hash + Float.floatToIntBits(this.subtotalInPounds);
        hash = 83 * hash + Objects.hashCode(this.discountsApplied);
        hash = 83 * hash + Float.floatToIntBits(this.totalInPounds);
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
        final Ticket other = (Ticket) obj;
        if (Float.floatToIntBits(this.subtotalInPounds) != Float.floatToIntBits(other.subtotalInPounds)) {
            return false;
        }
        if (Float.floatToIntBits(this.totalInPounds) != Float.floatToIntBits(other.totalInPounds)) {
            return false;
        }
        if (!Objects.equals(this.shoppingList, other.shoppingList)) {
            return false;
        }
        if (!Objects.equals(this.discountsApplied, other.discountsApplied)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "shoppingList=" + shoppingList + ", subtotalInPounds=" + subtotalInPounds + ", discountsApplied=" + discountsApplied + ", totalInPounds=" + totalInPounds + '}';
    }
}

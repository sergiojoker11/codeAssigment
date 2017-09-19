package sj11.priceBasket.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ticket {

    private List<Product> shoppingList;
    private float subtotalInPounds;
    private List<Discount> discountsApplied;
    private float totalInPounds;

    public Ticket() {
        shoppingList = new ArrayList<>();
        discountsApplied = new ArrayList<>();
    }

    public void addToSubtotal(float productoPrice) {
        subtotalInPounds += productoPrice;
    }

    public List<Product> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Product> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public float getSubtotalInPounds() {
        return subtotalInPounds;
    }

    public void setSubtotalInPounds(float subtotalInPounds) {
        this.subtotalInPounds = subtotalInPounds;
    }

    public List<Discount> getDiscountsApplied() {
        return discountsApplied;
    }

    public void setDiscountsApplied(List<Discount> discountsApplied) {
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

package sj11.priceBasket.till;

import java.util.Objects;
import sj11.priceBasket.entities.Ticket;

public class Till {

    private Printer printer;
    private ProductProvider productProvider;

    public Till() {
        this.printer = new Printer();
        this.productProvider = new ProductProvider();
    }

    public void charge(String[] shoppingItems) {
        //validate input (name -> Product)
        //Scan all items
        //Apply discounts
        //Print
    }

    private void applyDiscounts(Ticket ticket) {
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.printer);
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
        final Till other = (Till) obj;
        if (!Objects.equals(this.printer, other.printer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Till{" + "printer=" + printer + '}';
    }
}

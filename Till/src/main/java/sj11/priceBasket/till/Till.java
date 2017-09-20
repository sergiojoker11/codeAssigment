package sj11.priceBasket.till;

import java.util.Objects;
import sj11.priceBasket.entities.Ticket;
import sj11.priceBasket.services.DiscountService;
import sj11.priceBasket.services.ProductService;

public class Till extends AbstractBeanGetter {

    private final Printer printer;
    private final Scanner scanner;
    private final DiscountApplier discountApplier;

    public Till() {
        this.scanner = new Scanner((ProductService) getBean(ProductService.class));
        this.printer = new Printer();
        this.discountApplier = new DiscountApplier((DiscountService) getBean(DiscountService.class));
//        Product x1 = new Product("X1", 1.2f, false);
//        Product x2 = new Product("X2", 1.4f, false);
//        DiscountToApply key = new DiscountToApply(Arrays.asList(x1));
//        DiscountApplied value = new DiscountApplied(Arrays.asList(x2));
//        Discount discount = new Discount(key, value);
//        Discount save = discountProvider.save(discount);
//        System.out.println(save.toString());
    }

    public void charge(String[] shoppingItems) {
        Ticket ticket = scanner.validate(shoppingItems);
        scanner.scan(ticket);
//        discountApplier.applyDiscounts(ticket);
        printer.print(ticket);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.printer);
        hash = 29 * hash + Objects.hashCode(this.scanner);
        hash = 29 * hash + Objects.hashCode(this.discountApplier);
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
        if (!Objects.equals(this.scanner, other.scanner)) {
            return false;
        }
        return Objects.equals(this.discountApplier, other.discountApplier);
    }

    @Override
    public String toString() {
        return "Till{" + "printer=" + printer + ", scanner=" + scanner + ", discountApplier=" + discountApplier + '}';
    }
}

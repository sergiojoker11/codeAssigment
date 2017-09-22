package sj11.priceBasket.till;

import java.util.Locale;
import java.util.Set;
import org.springframework.stereotype.Component;
import sj11.priceBasket.entities.DiscountApplied;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;

@Component
public class Printer {

    private final float epsilon = 0.0000001f;

    public void print(Ticket ticket) {
        System.out.print("Subtotal: £");
        printPrice(ticket.getSubtotalInPounds());
        if (ticket.getDiscountsApplied().isEmpty()) {
            System.out.println("(No offers available)");
        } else {
            printDiscountsApplied(ticket.getDiscountsApplied());
        }
        System.out.print("Total price: £");
        printPrice(ticket.getTotalInPounds());
    }

    private void printDiscountsApplied(Set<DiscountApplied> discountsList) {
        discountsList.forEach((discount) -> {
            printDiscountApplied(discount);
        });
    }

    private void printDiscountApplied(DiscountApplied discountApplied) {
        Product product = discountApplied.getProductId1();
        if (product != null && compareRealNumbers(discountApplied.getProductRate1(), 0f)) {
            System.out.println(product.getName() + " " + Math.round(discountApplied.getProductRate1()) + "% off: -" + Math.round(product.getPriceInPounds() * discountApplied.getProductRate1()) + "p");
        }
        product = discountApplied.getProductId2();
        if (product != null && compareRealNumbers(discountApplied.getProductRate2(), 0f)) {
            System.out.println(product.getName() + " " + Math.round(discountApplied.getProductRate2()) + "% off: -" + Math.round(product.getPriceInPounds() * discountApplied.getProductRate2()) + "p");
        }
        product = discountApplied.getProductId3();
        if (product != null && compareRealNumbers(discountApplied.getProductRate3(), 0f)) {
            System.out.println(product.getName() + " " + Math.round(discountApplied.getProductRate3()) + "% off: -" + Math.round(product.getPriceInPounds() * discountApplied.getProductRate3()) + "p");
        }
        product = discountApplied.getProductId4();
        if (product != null && compareRealNumbers(discountApplied.getProductRate4(), 0f)) {
            System.out.println(product.getName() + " " + Math.round(discountApplied.getProductRate4()) + "% off: -" + Math.round(product.getPriceInPounds() * discountApplied.getProductRate4()) + "p");
        }
        product = discountApplied.getProductId5();
        if (product != null && compareRealNumbers(discountApplied.getProductRate5(), 0f)) {
            System.out.println(product.getName() + " " + Math.round(discountApplied.getProductRate5()) + "% off: -" + Math.round(product.getPriceInPounds() * discountApplied.getProductRate5()) + "p");
        }
    }

    private boolean compareRealNumbers(float factor1, float factor2) {
        return Math.abs(factor1 - factor2) < this.epsilon;
    }

    private void printPrice(float price) {
        System.out.format(Locale.UK, "%.2f%n", price);
    }
}

package sj11.priceBasket.till;

import java.util.List;
import sj11.priceBasket.entities.Discount;
import sj11.priceBasket.entities.Ticket;

public class Printer {

    public void print(Ticket ticket) {
        System.out.println("Subtotal: £" + ticket.getSubtotalInPounds());
        if (ticket.getDiscountsApplied().isEmpty()) {
            System.out.println("(No offers available)");
        } else {
            printDiscountsApplied(ticket.getDiscountsApplied());
        }
        System.out.println("Total price: £" + ticket.getTotalInPounds());
    }

    private void printDiscountsApplied(List<Discount> discountsList) {
        discountsList.forEach((discount) -> {
            System.out.println(discount.toString());
        });
    }
}

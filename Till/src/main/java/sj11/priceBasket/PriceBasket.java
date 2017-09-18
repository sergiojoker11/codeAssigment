package sj11.priceBasket;

import sj11.priceBasket.till.Till;

public class PriceBasket {

    public static void main(String[] args) {
        new Till().charge(args);
    }

}

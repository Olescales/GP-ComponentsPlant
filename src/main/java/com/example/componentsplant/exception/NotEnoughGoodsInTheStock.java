package com.example.componentsplant.exception;

public class NotEnoughGoodsInTheStock extends Exception {

    public NotEnoughGoodsInTheStock() {
        super();
    }

    public NotEnoughGoodsInTheStock(final String message) {
        super(message);
    }
}

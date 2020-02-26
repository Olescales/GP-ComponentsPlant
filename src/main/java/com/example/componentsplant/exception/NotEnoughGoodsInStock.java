package com.example.componentsplant.exception;

public class NotEnoughGoodsInStock extends Exception {

    public NotEnoughGoodsInStock () {
        super();
    }

    public NotEnoughGoodsInStock (final String message) {
        super(message);
    }
}

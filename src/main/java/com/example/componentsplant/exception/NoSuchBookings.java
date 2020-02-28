package com.example.componentsplant.exception;

public class NoSuchBookings extends Exception {

    public NoSuchBookings () {
        super();
    }

    public NoSuchBookings (final String message) {
        super(message);
    }

}

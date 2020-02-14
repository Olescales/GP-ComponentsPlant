package com.example.componentsplant.exception;

public class SuchClientAlreadyExistsException extends Exception {

    public SuchClientAlreadyExistsException () {
        super();
    }

    public SuchClientAlreadyExistsException (final String message) {
        super(message);
    }


}

package com.felipeivanaga.agrotis.exception;

public abstract class NotFoundWithIdException extends Exception {
    public NotFoundWithIdException(String message) {
        super(message);
    }
}

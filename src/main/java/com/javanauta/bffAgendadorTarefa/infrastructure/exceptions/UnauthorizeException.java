package com.javanauta.bffAgendadorTarefa.infrastructure.exceptions;

public class UnauthorizeException extends RuntimeException {
    public UnauthorizeException(String message) {
        super(message);
    }

    public UnauthorizeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

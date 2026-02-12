package com.javanauta.bffAgendadorTarefa.infrastructure.exceptions;

public class ConflitException extends RuntimeException {
    public ConflitException(String message) {
        super(message);
    }

    public ConflitException(String mensagem, Throwable throwable) {
        super(mensagem);
    }
}

package com.javanauta.bffAgendadorTarefa.controller;

import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.ConflitException;
import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.UnauthorizeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflitException.class)
    public ResponseEntity<String> handleConflitException(ConflitException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizeException.class)
    public ResponseEntity<String> handleUnauthorizeException(UnauthorizeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}

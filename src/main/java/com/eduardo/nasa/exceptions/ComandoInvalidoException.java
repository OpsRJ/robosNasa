package com.eduardo.nasa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Comando Inválido!")
public class ComandoInvalidoException extends RuntimeException {

    public ComandoInvalidoException() {
        super();
    }

    public ComandoInvalidoException(String msg) {
        super(msg);
    }
}

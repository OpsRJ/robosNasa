package com.eduardo.nasa.exceptions;

public class MovimentarException extends RuntimeException {

    public  MovimentarException() {
        super();
    }

    public  MovimentarException(String msg) {
        super(msg);
    }
}

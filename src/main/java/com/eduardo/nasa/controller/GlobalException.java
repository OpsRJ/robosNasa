package com.eduardo.nasa.controller;

import com.eduardo.nasa.exceptions.ComandoInvalidoException;
import com.eduardo.nasa.exceptions.MovimentarException;
import com.eduardo.nasa.model.ErroMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalException {

    @ExceptionHandler({MovimentarException.class, ComandoInvalidoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErroMsg> handleException(RuntimeException ex, WebRequest request) {
        ErroMsg error = new ErroMsg();
        error.setMsgErro(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}

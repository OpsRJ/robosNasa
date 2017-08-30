package com.eduardo.nasa.controller;

import com.eduardo.nasa.exceptions.ComandoInvalidoException;
import com.eduardo.nasa.exceptions.MovimentarException;
import com.eduardo.nasa.model.ErroMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalException {

    @ExceptionHandler({MovimentarException.class, ComandoInvalidoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(RuntimeException ex, WebRequest request) {
          return ex.getMessage();
    }
}

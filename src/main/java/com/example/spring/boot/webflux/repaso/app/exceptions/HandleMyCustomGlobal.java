package com.example.spring.boot.webflux.repaso.app.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class HandleMyCustomGlobal {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public String handleMyCustomException(RecursoNoEncontradoException ex) {
        var exc =  new ResponseStatusException(ex.getHttpStatus(), ex.getMessage(),ex);
        return exc.getReason();

    }

}

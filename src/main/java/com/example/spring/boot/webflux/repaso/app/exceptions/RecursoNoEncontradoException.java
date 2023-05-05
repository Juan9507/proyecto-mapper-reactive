package com.example.spring.boot.webflux.repaso.app.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RecursoNoEncontradoException extends RuntimeException {

    private String mensaje;

    private HttpStatus httpStatus;
    public RecursoNoEncontradoException(String mensaje, HttpStatus httpStatus) {
        super(mensaje);
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
    }
}


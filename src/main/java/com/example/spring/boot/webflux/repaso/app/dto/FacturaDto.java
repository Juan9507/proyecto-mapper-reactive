package com.example.spring.boot.webflux.repaso.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FacturaDto {

    private String id;
    private Integer numFactura;
    private String idCliente;
    private Date fecha;
}

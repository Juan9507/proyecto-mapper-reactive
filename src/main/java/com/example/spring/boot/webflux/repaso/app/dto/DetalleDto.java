package com.example.spring.boot.webflux.repaso.app.dto;

import lombok.Data;

@Data
public class DetalleDto {

    private String id;
    private Integer idFactura;
    private String idProducto;
    private Double cantidad;
    private Double precio;
}

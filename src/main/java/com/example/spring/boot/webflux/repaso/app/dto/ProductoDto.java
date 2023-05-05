package com.example.spring.boot.webflux.repaso.app.dto;

import lombok.Data;

@Data
public class ProductoDto {

    private String id;
    private Integer idProducto;
    private String nombre;
    private Integer precio;
    private Integer stock;
}

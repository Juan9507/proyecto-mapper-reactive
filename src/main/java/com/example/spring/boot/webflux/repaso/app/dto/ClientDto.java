package com.example.spring.boot.webflux.repaso.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {

    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Date fechaNacimiento;
    private String telefono;
    private String email;
}

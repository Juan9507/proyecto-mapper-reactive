package com.example.spring.boot.webflux.repaso.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDocument {

    @Id
    private String id;
    @Indexed(unique = true)
    private Integer numFactura;
    private String idCliente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
}

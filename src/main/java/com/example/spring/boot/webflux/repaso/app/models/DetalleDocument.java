package com.example.spring.boot.webflux.repaso.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleDocument {

    @Id
    private String id;
    @Indexed(unique = true)
    private Integer id_factura;
    private String idProducto;
    private Double cantidad;
    private Double Precion;
}

package com.example.spring.boot.webflux.repaso.app.controllers;

import com.example.spring.boot.webflux.repaso.app.dto.FacturaDto;
import com.example.spring.boot.webflux.repaso.app.usecase.FacturaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class FacturaController {

    private final FacturaUseCase facturaUseCase;

    @PostMapping("/crear/factura")
    public Mono<FacturaDto> crearFactura(@RequestBody FacturaDto factura){
        return facturaUseCase.crearFactura(factura);
    }
}

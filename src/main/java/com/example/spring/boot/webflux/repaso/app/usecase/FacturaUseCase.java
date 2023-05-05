package com.example.spring.boot.webflux.repaso.app.usecase;

import com.example.spring.boot.webflux.repaso.app.dto.FacturaDto;
import com.example.spring.boot.webflux.repaso.app.exceptions.RecursoNoEncontradoException;
import com.example.spring.boot.webflux.repaso.app.models.FacturaDocument;
import com.example.spring.boot.webflux.repaso.app.repositories.ClienteRepository;
import com.example.spring.boot.webflux.repaso.app.repositories.FacturaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class FacturaUseCase {

    private final ModelMapper modelMap;

    private final FacturaRepository facturaRepository;

    private final ClienteRepository clienteRepository;


    public Flux<FacturaDto> listarFacturas(){

        return facturaRepository.findAll()
                .map(facturas -> modelMap.map(facturas, FacturaDto.class));

    }

    public Mono<FacturaDto> crearFactura(FacturaDto facturaDto) {
        return clienteRepository.findById(facturaDto.getIdCliente())
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(optionalClient -> {
                    if(optionalClient.isPresent()){
                        var facturaDocument = modelMap.map(facturaDto, FacturaDocument.class);
                        return facturaRepository.save(facturaDocument)
                                .map(facturas -> modelMap.map(facturas, FacturaDto.class));
                    }
                    return Mono.error(new RecursoNoEncontradoException("El cliente no es valido para asignarle una factura", HttpStatus.NOT_FOUND));
                });
    }
}

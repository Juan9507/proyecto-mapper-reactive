package com.example.spring.boot.webflux.repaso.app.usecase;

import com.example.spring.boot.webflux.repaso.app.models.DetalleDocument;
import com.example.spring.boot.webflux.repaso.app.repositories.DetalleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
@Validated
public class DetalleUseCase {

    private final ModelMapper modelMap;
    private final DetalleRepository detalleRepository;

    public Flux<DetalleDocument> listarDetalles(){
        return detalleRepository.findAll();
    }
}

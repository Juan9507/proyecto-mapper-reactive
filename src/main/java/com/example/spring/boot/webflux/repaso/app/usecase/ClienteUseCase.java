package com.example.spring.boot.webflux.repaso.app.usecase;

import com.example.spring.boot.webflux.repaso.app.dto.ClientDto;
import com.example.spring.boot.webflux.repaso.app.exceptions.RecursoNoEncontradoException;
import com.example.spring.boot.webflux.repaso.app.models.ClienteDocument;
import com.example.spring.boot.webflux.repaso.app.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Validated
public class ClienteUseCase {

    private final ModelMapper modelMapper;

    private final ClienteRepository clienteRepository;

    public Mono<ClientDto> guardarCliente(ClientDto clientDto) {

        ClienteDocument clienteConversion = modelMapper.map(clientDto, ClienteDocument.class);

        return clienteRepository.save(clienteConversion)
                .flatMap(e -> Mono.just(modelMapper.map(e, ClientDto.class)))
                .onErrorResume(t -> Mono.error(new RecursoNoEncontradoException(t.getMessage(), HttpStatus.BAD_REQUEST)));
    }

    public Mono<ResponseEntity<Flux<ClientDto>>> listarClientes() {
        var clientes = clienteRepository.findAll()
                .map(e -> modelMapper.map(e, ClientDto.class));
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(clientes)
        );

    }

    public Mono<ResponseEntity<ClientDto>> buscarClientePorId(String id) {
        return clienteRepository.findById(id)
                .map(e -> ResponseEntity.ok().body(modelMapper.map(e, ClientDto.class)))
                .switchIfEmpty(Mono.error(new RecursoNoEncontradoException("El cliente no existe", HttpStatus.NOT_FOUND)));
    }
}

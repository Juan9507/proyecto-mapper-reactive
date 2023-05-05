package com.example.spring.boot.webflux.repaso.app.controllers;

import com.example.spring.boot.webflux.repaso.app.dto.ClientDto;
import com.example.spring.boot.webflux.repaso.app.usecase.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClientController {

    private final ClienteUseCase clienteUseCase;

    @PostMapping("/")
    public Mono<ClientDto> guardarCliente(@RequestBody ClientDto clientDto){
        return clienteUseCase.guardarCliente(clientDto);
    }

    @GetMapping("/listar/clientes")
    public Mono<ResponseEntity<Flux<ClientDto>>> listarClientes(){
        return clienteUseCase.listarClientes();
    }

    @GetMapping("/listar/cliente/{id}")
    public Mono<ResponseEntity<ClientDto>> buscarClientePorId(@PathVariable("id") String id){
        return clienteUseCase.buscarClientePorId(id);
    }
}

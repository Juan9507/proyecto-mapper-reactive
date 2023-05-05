package com.example.spring.boot.webflux.repaso.app.usecase;

import com.example.spring.boot.webflux.repaso.app.dto.ClientDto;
import com.example.spring.boot.webflux.repaso.app.models.ClienteDocument;
import com.example.spring.boot.webflux.repaso.app.repositories.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClienteUseCaseTest {

    @Mock
    ClienteRepository clienteRepository;

    @Mock
    WebClient webClient;

    @Mock
    ClienteUseCase clienteUseCase;

    @Mock
    ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    public void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        clienteUseCase = new ClienteUseCase(modelMapper, clienteRepository);
    }

    @Test
    void PostValidationTest() {

        // Arrange
        var cliente = new ClienteDocument();
        //cliente.setId("44234");
        cliente.setNombre("Juan");
        cliente.setApellido("Rivera");
        cliente.setDireccion("calle 322");
        cliente.setTelefono("343442");
        //cliente.setFechaNacimiento(new Date("1995-23-33"));

        var clienteDto = new ClientDto();
        //cliente.setId(cliente.getId());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setDireccion(cliente.getDireccion());
        clienteDto.setTelefono(cliente.getTelefono());
        //clienteDto.setFechaNacimiento(cliente.getFechaNacimiento());

        // Act
        when(clienteRepository.save(Mockito.any(ClienteDocument.class))).thenReturn(Mono.just(cliente));

        // Assert

        StepVerifier.create(clienteUseCase.guardarCliente(clienteDto))
                .expectNext(clienteDto)
                .expectComplete()
                .verify();

    }

    @Test
    public void getListarClientes(){
        // Arrange
        var cliente1 = new ClienteDocument();
        //cliente.setId("44234");
        cliente1.setNombre("Juan");
        cliente1.setApellido("Rivera");
        cliente1.setDireccion("calle 322");
        cliente1.setTelefono("343442");
        //cliente.setFechaNacimiento(new Date("1995-23-33"));

        var cliente1Dto = new ClientDto();
        //cliente.setId(cliente.getId());
        cliente1Dto.setNombre(cliente1.getNombre());
        cliente1Dto.setApellido(cliente1.getApellido());
        cliente1Dto.setDireccion(cliente1.getDireccion());
        cliente1Dto.setTelefono(cliente1.getTelefono());
        //clienteDto.setFechaNacimiento(cliente.getFechaNacimiento());

        var cliente2 = new ClienteDocument();
        //cliente.setId("44234");
        cliente2.setNombre("David");
        cliente2.setApellido("Naranjo");
        cliente2.setDireccion("calle 322");
        cliente2.setTelefono("343442");
        //cliente.setFechaNacimiento(new Date("1995-23-33"));

        var cliente2Dto = new ClientDto();
        //cliente.setId(cliente.getId());
        cliente2Dto.setNombre(cliente2.getNombre());
        cliente2Dto.setApellido(cliente2.getApellido());
        cliente2Dto.setDireccion(cliente2.getDireccion());
        cliente2Dto.setTelefono(cliente2.getTelefono());
        //clienteDto.setFechaNacimiento(cliente.getFechaNacimiento());

        List<ClienteDocument> listaClientes = new ArrayList<>();

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        when(clienteRepository.findAll()).thenReturn(Flux.fromIterable(listaClientes));

        var resultados = clienteRepository.findAll();

        StepVerifier.create(resultados.count())
                .expectNext(2L)
                .verifyComplete();

    }


}
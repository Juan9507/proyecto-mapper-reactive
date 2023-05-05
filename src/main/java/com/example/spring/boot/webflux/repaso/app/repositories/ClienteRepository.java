package com.example.spring.boot.webflux.repaso.app.repositories;

import com.example.spring.boot.webflux.repaso.app.models.ClienteDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface ClienteRepository extends ReactiveMongoRepository<ClienteDocument, String>,
        ReactiveQueryByExampleExecutor<ClienteDocument> {

}

package com.example.spring.boot.webflux.repaso.app.repositories;

import com.example.spring.boot.webflux.repaso.app.models.DetalleDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface DetalleRepository extends ReactiveMongoRepository<DetalleDocument, String>,
        ReactiveQueryByExampleExecutor<DetalleDocument> {
}

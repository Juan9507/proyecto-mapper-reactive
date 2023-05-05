package com.example.spring.boot.webflux.repaso.app.repositories;

import com.example.spring.boot.webflux.repaso.app.models.FacturaDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface FacturaRepository extends ReactiveMongoRepository<FacturaDocument, String>,
        ReactiveQueryByExampleExecutor<FacturaDocument> {
}

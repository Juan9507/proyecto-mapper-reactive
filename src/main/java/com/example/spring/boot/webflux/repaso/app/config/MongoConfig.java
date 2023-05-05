package com.example.spring.boot.webflux.repaso.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


/**
 * Clase de configuración mongodb
 * EnableMongoRepositoriesdebe establecerse.
 * Esto buscará clases en el paquete especificado que se extienda MongoRepository
 */
@Configuration
@EnableMongoRepositories("com.example.spring.boot.webflux.repaso.app.repositories")
public class MongoConfig {

    /**
     * ValidatingMongoEventListener todos los documentos se validen antes de persistir,
     * podemos ampliar sus campos con javax.validation
     * @param factory - validation
     */
    @Bean
    public ValidatingMongoEventListener validationEventListener(
            final LocalValidatorFactoryBean factory) {
        return new ValidatingMongoEventListener(factory);
    }

}

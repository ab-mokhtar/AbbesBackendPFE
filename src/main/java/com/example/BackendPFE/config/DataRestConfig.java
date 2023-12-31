package com.example.BackendPFE.config;

import com.example.BackendPFE.model.Demande;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;


@Configuration
@AllArgsConstructor
public class DataRestConfig implements RepositoryRestConfigurer {
    private EntityManager entityManager;

    //we will expose id for car api
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

    }
}

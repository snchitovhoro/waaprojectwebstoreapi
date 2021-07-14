package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
    Flux<Product> findAll();

    Mono<Product> findByProductNumber(Long productNumber);

    void create(Product product);

    Mono<Product> findById(Integer id);

    Flux<Product> findByName(String name);

    Mono<Product> update(Product product);

    Mono<Void> delete(Integer id);

}
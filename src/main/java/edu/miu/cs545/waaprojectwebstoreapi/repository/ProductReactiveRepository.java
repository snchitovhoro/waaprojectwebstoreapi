package edu.miu.cs545.waaprojectwebstoreapi.repository;

import edu.miu.cs545.waaprojectwebstoreapi.model.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductReactiveRepository
        extends ReactiveMongoRepository<Product, Long> {
    Flux<Product> findAll();

    Mono<Product> findByProductNumber(Long productNumber);

    Mono<Product> findById(Integer id);

    @Query("{ 'description': ?0 }")
    Flux<Product> findByDescriptionContaining(String name);

    Mono<Product> insert(Product product);

    Mono<Void> deleteById(Integer id);

}
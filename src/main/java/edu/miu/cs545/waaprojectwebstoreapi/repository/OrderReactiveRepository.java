package edu.miu.cs545.waaprojectwebstoreapi.repository;

import edu.miu.cs545.waaprojectwebstoreapi.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderReactiveRepository
        extends ReactiveMongoRepository<Order, Long> {

    Flux<Order> findAll();

    Mono<Order> findByOrderNumber(Long orderNumber);

    Mono<Order> save(Order order);

    Mono<Order> findById(Long id);



    Mono<Void> deleteById(Long id);

}
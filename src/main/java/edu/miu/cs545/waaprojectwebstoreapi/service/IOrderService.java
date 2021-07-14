package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOrderService {

    Flux<Order> findAll();

    Mono<Order> findByOrderNumber(Long orderNumber);

    Mono<Order> save(Order order);

    Mono<Order> findById(Long id);

    Mono<Order> update(Order order);

    Mono<Void> delete(Long id);
}
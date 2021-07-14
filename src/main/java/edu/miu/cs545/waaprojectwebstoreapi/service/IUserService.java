package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
    Flux<User> findAll();

    Mono<User> findByUserName(String username);

    Mono<User> create(User user);

    Mono<User> findById(Long id);

    Flux<User> findByName(String name);

    Mono<User> update(User user);

    Mono<Void> delete(Long id);

}
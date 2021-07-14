package edu.miu.cs545.waaprojectwebstoreapi.repository;

import edu.miu.cs545.waaprojectwebstoreapi.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserReactiveRepository
        extends ReactiveMongoRepository<User, Long> {

    Flux<User> findAll();

    Mono<User> findByUserName(String username);

    Mono<User> findById(Long id);

    @Query("{ 'name': ?0 }")
    Flux<User> findByName(String name);

    Mono<Void> deleteById(Long id);

}
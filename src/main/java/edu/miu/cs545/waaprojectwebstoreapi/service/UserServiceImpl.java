package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.User;
import edu.miu.cs545.waaprojectwebstoreapi.repository.UserReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserReactiveRepository userReactiveRepository;


    @Override
    public Flux<User> findAll() {
        return userReactiveRepository.findAll();
    }

    @Override
    public Mono<User> findByUserName(String username) {
        return userReactiveRepository.findByUserName(username);
    }

    @Override
    public Mono<User> create(User user) {
        userReactiveRepository.save(user);
        return Mono.just(user);

    }

    @Override
    public Mono<User> findById(Long id) {
        return userReactiveRepository.findById(id);
    }

    @Override
    public Flux<User> findByName(String name) {
        return userReactiveRepository.findByName(name);
    }

    @Override
    public Mono<User> update(User user) {
        return userReactiveRepository.insert(user);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return userReactiveRepository.deleteById(id);
    }
}
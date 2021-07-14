package edu.miu.cs545.waaprojectwebstoreapi.controller;

import edu.miu.cs545.waaprojectwebstoreapi.model.User;
import edu.miu.cs545.waaprojectwebstoreapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        Flux<User> allUsers = userService.findAll();
        HttpStatus status = allUsers != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(allUsers, status);
    }

    @GetMapping("/{username}")
    ResponseEntity<?> findByUserName(String username) {
        Mono<User> user = userService.findByUserName(username);
        HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<User>>(user, status);
    }

    @PostMapping("/")
    ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Mono<User> newuser = userService.create(user);
        HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<User>>(newuser, status);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findById(Long id) {
        Mono<User> user = userService.findById(id);
        HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<User>>(user, status);
    }

    @GetMapping("/{name}")
    ResponseEntity<?> findByName(@PathVariable String name) {
        Mono<User> user = userService.findByUserName(name);
        HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<User>>(user, status);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Mono<User> updateduser = userService.update(user);
        HttpStatus status = updateduser != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(updateduser, status);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(Long id) {
        Mono<User> deleteduser = userService.findById(id);
        if (deleteduser != null)
            userService.delete(id);
        HttpStatus status = deleteduser != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<String>("deleted", status);
    }
}

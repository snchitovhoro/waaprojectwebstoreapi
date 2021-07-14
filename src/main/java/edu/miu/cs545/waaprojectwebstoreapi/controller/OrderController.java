package edu.miu.cs545.waaprojectwebstoreapi.controller;

import edu.miu.cs545.waaprojectwebstoreapi.model.Order;
import edu.miu.cs545.waaprojectwebstoreapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/oders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/")
    public ResponseEntity<?> getAllOrders() {

        Flux<Order> allOrders = orderService.findAll();

        HttpStatus status = allOrders != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Flux<Order>>(allOrders, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable Long id) {

        Mono<Order> order = orderService.findByOrderNumber(id);

        HttpStatus status = order != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Order>>(order, status);
    }

    @PostMapping("/")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order, BindingResult result) {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Mono<Order> newOrder = orderService.save(order);

        HttpStatus status = newOrder != null ? HttpStatus.CREATED : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Order>>(newOrder, status);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody Order order, BindingResult result) {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Mono<Order> newOrder = orderService.update(order);

        HttpStatus status = newOrder != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Order>>(newOrder, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<String>("Deleted", status);
    }

}

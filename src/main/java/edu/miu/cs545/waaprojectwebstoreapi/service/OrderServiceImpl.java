package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Order;
import edu.miu.cs545.waaprojectwebstoreapi.repository.OrderReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderReactiveRepository orderReactiveRepository;


    @Override
    public Flux<Order> findAll() {
        return orderReactiveRepository.findAll();
    }

    @Override
    public Mono<Order> findByOrderNumber(Long orderNumber) {

        Mono<Order> order = orderReactiveRepository.findByOrderNumber(orderNumber);
        order.then().subscribe();
        //OrderDTO orderDTO = OderDtoAdapter.getDto(order);
        return order;
    }

    @Override
    public Mono<Order> save(Order order) {
        //Order order = OderDtoAdapter.getOrder(orderDTO);
        return orderReactiveRepository.save(order);
    }

    @Override
    public Mono<Order> findById(Long id) {
        return orderReactiveRepository.findById(id);
    }

    @Override
    public Mono<Order> update(Order order) {
        return orderReactiveRepository.insert(order);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return orderReactiveRepository.deleteById(id);
    }
}
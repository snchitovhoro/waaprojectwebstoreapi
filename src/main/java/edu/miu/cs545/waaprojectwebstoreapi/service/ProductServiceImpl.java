package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Product;
import edu.miu.cs545.waaprojectwebstoreapi.repository.ProductReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductReactiveRepository productReactiveRepository;

    @Override
    public Flux<Product> findAll() {
        return productReactiveRepository.findAll();
    }

    @Override
    public Mono<Product> findByProductNumber(Long productNumber) {
        return productReactiveRepository.findByProductNumber(productNumber);
    }

    @Override
    public void create(Product product) {
        productReactiveRepository.save(product);
    }

    @Override
    public Mono<Product> findById(Integer id) {
        return productReactiveRepository.findById(id);
    }

    @Override
    public Flux<Product> findByName(String name) {
        return productReactiveRepository.findByDescriptionContaining(name);
    }

    @Override
    public Mono<Product> update(Product product) {
        return productReactiveRepository.insert(product);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return productReactiveRepository.deleteById(id);
    }
}
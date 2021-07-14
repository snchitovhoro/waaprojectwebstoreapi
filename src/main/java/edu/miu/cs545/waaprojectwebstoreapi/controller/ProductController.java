package edu.miu.cs545.waaprojectwebstoreapi.controller;

import edu.miu.cs545.waaprojectwebstoreapi.model.Product;
import edu.miu.cs545.waaprojectwebstoreapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {

        Flux<Product> allProducts = productService.findAll();

        HttpStatus status = allProducts != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Flux<Product>>(allProducts, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByProductNumber(@PathVariable Long productNumber) {

        Mono<Product> product = productService.findByProductNumber(productNumber);

        HttpStatus status = product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Product>>(product, status);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {

        productService.create(product);

        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<String>("success", status);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product) {

        Mono<Product> newProduct = productService.update(product);

        HttpStatus status = newProduct != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Product>>(newProduct, status);
    }


}

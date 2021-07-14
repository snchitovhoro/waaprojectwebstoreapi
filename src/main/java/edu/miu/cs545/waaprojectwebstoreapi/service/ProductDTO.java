package edu.miu.cs545.waaprojectwebstoreapi.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

@Document
@CrossOrigin
public class ProductDTO {
    @Id
    private Long id;
    private Long productNumber;
    private String description;
    private int numberInStock;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, Long productNumber, String description, int numberInStock, double price) {
        this.id = id;
        this.productNumber = productNumber;
        this.description = description;
        this.numberInStock = numberInStock;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

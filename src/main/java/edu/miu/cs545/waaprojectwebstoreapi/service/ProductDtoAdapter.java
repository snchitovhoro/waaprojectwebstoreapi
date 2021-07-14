package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.Product;

public class ProductDtoAdapter {

    public static ProductDTO getDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductNumber(product.getProductNumber());
        productDTO.setDescription(product.getDescription());
        productDTO.setNumberInStock(product.getNumberInStock());
        productDTO.setPrice(product.getPrice());
        return productDTO;

    }

    public static Product getProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductNumber(productDto.getProductNumber());
        product.setDescription(productDto.getDescription());
        product.setNumberInStock(productDto.getNumberInStock());
        product.setPrice(productDto.getPrice());
        return product;
    }
}

package com.datrastoco.administration_service.products.services;

import com.datrastoco.administration_service.products.entities.Product;
import com.datrastoco.administration_service.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices{

    @Autowired
    ProductRepository productRepository;

//  CREATE PRODUCT.....................................

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

//  GET PRODUCTS LIST ....................................

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

//  UPDATE PRODUCT..................................

    @Override
    public Product updateProduct(Integer productId, Product productDetails) {

        Product product = productRepository.findById(productId).get();
        product.setName(productDetails.getName());
        product.setCompany(productDetails.getCompany());
        product.setSize(productDetails.getSize());
        product.setType(productDetails.getType());

        return productRepository.save(product);
    }

//  DELETE PRODUCT ........................................

    @Override
    public Product deleteProduct(Integer productId, Product productDetails) {

        Product product = productRepository.findById(productId).get();
        product.setStatus(productDetails.getStatus());

        return productRepository.save(product);
    }

//  GET PRODUCT ..........................................
    @Override
    public Product getProduct(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            return product.get();
        } throw new RuntimeException("User is not found for id:" + productId);
    }
}

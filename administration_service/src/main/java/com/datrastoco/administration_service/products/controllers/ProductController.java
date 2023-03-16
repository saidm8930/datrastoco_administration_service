package com.datrastoco.administration_service.products.controllers;

import com.datrastoco.administration_service.enterprises.entities.Enterprise;
import com.datrastoco.administration_service.products.entities.Product;
import com.datrastoco.administration_service.products.repositories.ProductRepository;
import com.datrastoco.administration_service.products.services.ProductServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductServicesImpl productServicesImpl;

    //  CREATE PRODUCT........................................

    @RequestMapping(value="/v1/products", method= RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productServicesImpl.createProduct(product);
    }

    //  GET PRODUCT LIST .........................................

    @RequestMapping(value="/v1/products", method=RequestMethod.GET)
    public List<Product> readProducts() {
        return productServicesImpl.getProducts();
    }

    //  GET PRODUCT ..........................................

    @RequestMapping(value = "/v1/products/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(value = "productId") Integer id){
        return productServicesImpl.getProduct(id);
    }

    //  UPDATE PRODUCT........................................

    @RequestMapping(value="/v1/products/{productId}", method=RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "productId") Integer id, @RequestBody Product productDetails) {
        return productServicesImpl.updateProduct(id, productDetails);
    }

    //  DELETE PRODUCT..............................

    @RequestMapping(value="/v1/deleteProduct/{productId}", method=RequestMethod.PUT)
    public Product deleteProduct(@PathVariable(value = "productId") Integer id, @RequestBody Product productDetails) {
        return productServicesImpl.deleteProduct(id, productDetails);
    }

}

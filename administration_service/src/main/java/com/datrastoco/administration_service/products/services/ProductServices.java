package com.datrastoco.administration_service.products.services;

import com.datrastoco.administration_service.enterprises.entities.Enterprise;
import com.datrastoco.administration_service.products.entities.Product;

import java.util.List;

public interface ProductServices {
    //  CREATE PRODUCT......................................
    Product createProduct(Product product);

    //  GET LIST PRODUCTS...................................
    List<Product> getProducts();

    //  UPDATE PRODUCT.......................................
    Product updateProduct(Integer productId, Product productDetails);

    //  DELETE PRODUCT
    Product deleteProduct(Integer productId, Product productDetails);

    //  GET ENTERPRISE
    Product getProduct(Integer productId);
}

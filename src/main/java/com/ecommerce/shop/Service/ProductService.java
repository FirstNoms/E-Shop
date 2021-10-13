package com.ecommerce.shop.Service;

import com.ecommerce.shop.data.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();

}

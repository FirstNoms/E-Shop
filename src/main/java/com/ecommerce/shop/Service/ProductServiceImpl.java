package com.ecommerce.shop.Service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        Product productToUpdate = productRepository.findById(product.getId()).orElse(null);
        if (product.getName() != null){
            productToUpdate.setName(product.getName());
        }
        if (product.getPrice() != null){
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getCurrency() != null){
            productToUpdate.setCurrency(product.getCurrency());
        }
        if (product.getDetails() != null){
            productToUpdate.setDetails(product.getDetails());
        }
        productRepository.save(productToUpdate);
        return productToUpdate;
    }
}

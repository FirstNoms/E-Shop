package com.ecommerce.shop.Service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;


    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }
    @Test
    void updateProductMockTest(){
        Product product = new Product();
        product.setId(110L);
        product.setName("Chinomso");
        product.setPrice(5000.60);

        Product productForm = new Product();
        productForm.setId(110L);
        productForm.setName("Updated");
        productForm.setPrice(6000.00);
        when(productRepository.findById(110L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(productForm);
        Product updatedProduct = productServiceImpl.update(productForm);
        verify(productRepository, times(1)).findById(110L);
        verify(productRepository, times(1)).save(product);
        when(productRepository.findById(110L)).thenReturn(Optional.of(updatedProduct));
        Product productFound = productServiceImpl.findById(110L);
        assertTrue(updatedProduct.getName().equals(productFound.getName()));
    }
}
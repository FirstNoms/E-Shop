package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.Service.ProductService;
import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepositoryImpl;
    @Autowired
    ProductService productServiceImpl;


    @BeforeEach
    void setUp() {
    }

    @Test
    public void createProductTest(){
        Product product = new Product();
        product.setName("Luxury Sofa");
        product.setPrice(400D);
        product.setCurrency(Currency.NGN);
        product.setDetails("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
                "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium\n" +


        assertThat(product).isNotNull());
        assertThat(product.getId()).isNull();
        log.info("Product before saving -> {}", product);
        productRepositoryImpl.save(product);
        assertThat(product.getId()).isNotNull();
        log.info("Product after saving -> {}", product);

    }

    @Test
    @Transactional
    public void testForWhenFindAllProductIsCalledTheProductListIsReturned(){
        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(4);
        log.info("Product returned from database -> {}", products);
    }


    @Test
    public void findExistingProductById(){
        Product existingProduct =
                productRepositoryImpl.findById(110L).orElse(null);
        assertThat(existingProduct).isNotNull();
        log.info("Product -> {}", existingProduct);
    }

    @Test
    public void deleteExistingProductById(){
        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNotNull();
        productRepositoryImpl.deleteById(110L);
        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNull();
    }
    @Test
    public void updateProduct(){
        Product productToUpdate = productRepositoryImpl.findById(110L).orElse(null);
        Product updatedProduct = null;
                assertThat(updatedProduct.getId().equals(111L));

    }
}
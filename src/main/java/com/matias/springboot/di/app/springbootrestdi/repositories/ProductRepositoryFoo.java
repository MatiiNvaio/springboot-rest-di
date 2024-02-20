package com.matias.springboot.di.app.springbootrestdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.matias.springboot.di.app.springbootrestdi.models.Product;

// Al haber dos implementaciones del Repository, se le da prioridad al que esta anotado con @Primary
// @Primary
@Repository("repositoryFoo")
public class ProductRepositoryFoo implements IProductRespository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Play Station 5 white", 1500L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Play Station 5 white", 1500L);
    }
 
}

package com.matias.springboot.di.app.springbootrestdi.repositories;

import java.util.List;

import com.matias.springboot.di.app.springbootrestdi.models.Product;

public interface IProductRespository {

    List<Product> findAll();
    Product findById(Long id);
    // Product findById2(Long id);
}

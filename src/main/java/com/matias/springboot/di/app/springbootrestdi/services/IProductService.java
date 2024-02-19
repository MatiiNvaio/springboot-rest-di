package com.matias.springboot.di.app.springbootrestdi.services;

import java.util.List;

import com.matias.springboot.di.app.springbootrestdi.models.Product;

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);

}

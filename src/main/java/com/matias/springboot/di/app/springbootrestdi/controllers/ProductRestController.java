package com.matias.springboot.di.app.springbootrestdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.matias.springboot.di.app.springbootrestdi.models.Product;
import com.matias.springboot.di.app.springbootrestdi.services.IProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    // Otra manera de hacer inyeccion de dependencia, y no es necesaria la anotación @Autowired
    // public ProductRestController(IProductService productService) {
    //     this.productService = productService;
    // }

    @GetExchange("")
    public List<Product> list(){
        return productService.findAll();
    }

    @GetExchange("/{id}")
    public Product product(@PathVariable Long id){
        return productService.findById(id);
    }
}

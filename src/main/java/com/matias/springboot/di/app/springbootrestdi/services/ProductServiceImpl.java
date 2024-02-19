package com.matias.springboot.di.app.springbootrestdi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.springboot.di.app.springbootrestdi.models.Product;
import com.matias.springboot.di.app.springbootrestdi.repositories.IProductRespository;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRespository productRepository;

    @Override
    public List<Product> findAll(){

        // con stream().map() podemos acceder a los objetos y manipularlos
        return productRepository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 0.21;
            // nuevo objeto Product con los datos obtenidos del map, para respetar el principio de inmutabilidad
            // no se va a modificar en cada flujo que se cree
            Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            return newProduct;
        }).toList(); // convierte el stream en una lista, asi podemos retornar
    }

    @Override
    public Product findById(Long id){
        Product product = productRepository.findById(id);

        return product;
    }
}

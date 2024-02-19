package com.matias.springboot.di.app.springbootrestdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.matias.springboot.di.app.springbootrestdi.models.Product;

@Repository
public class ProductRepositoryImpl implements IProductRespository{

    private List<Product> data;

    // con el constructor lleno la lista de productos
    public ProductRepositoryImpl() {

        this.data = Arrays.asList(

            new Product(1L, "Monitor Samsung 24'", 2500L),
            new Product(2L, "Mouse Logitec MS-D 3", 1300L),
            new Product(3L, "Memoria RAM Corsair 16GB", 500L),
            new Product(4L, "Placa de video Nvidia RTX 4090", 2200L)
        );
    }

    // devuelve la lista de Productos
    @Override
    public List<Product> findAll(){
        return data;
    }

    
    // devuelve el producto segun el id que le pasemos
    @Override
    public Product findById(Long id){
        Product producto = data.get(id.intValue()-1);
        return producto;
    }

    
    // otra manera de obtener por su id
    // @Override
    // public Product findById2(Long id){
    //      /* 
    //         crea un flujo de datos con stream(), filtra aquellos objetos cuyo id sea igual a 'id' p.getId().equals(id)
    //         luego devuelve el primer elemento y si no lo encuentra, un objeto null
    //      */
    //     return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    // }
}

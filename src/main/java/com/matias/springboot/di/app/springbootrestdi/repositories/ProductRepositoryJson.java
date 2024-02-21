package com.matias.springboot.di.app.springbootrestdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matias.springboot.di.app.springbootrestdi.models.Product;

// clase para leer un archivo JSON
public class ProductRepositoryJson implements IProductRespository{

    private static List<Product> list;

    public ProductRepositoryJson(){
    // lee la ruta de nuestro archivo JSON, asi se obtiene de forma progrmatica
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    // y esta es la manera de obtener el resourse de forma declarativa, y lo pasamos por parametro
    public ProductRepositoryJson(Resource resource){
        readValueJson(resource);
    }

    static private void readValueJson(Resource resource){
        // convierte el JSON a una lista
        ObjectMapper mapper = new ObjectMapper();
        try {
            // crea la lista con asList, el metodo readValue sirve para leer el archivo JSON y llena un arreglo de Product
            list = Arrays.asList(
                mapper.readValue(resource.getInputStream(), Product[].class)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        // stream para filtrar sobre list y poder retornar el primer elemento con el id del parametro, si no lo encuentre devulve null
        return (Product) list.stream().filter(p -> {
            return p.getId().equals(id);
        }).findFirst().orElse(null);
    }
}

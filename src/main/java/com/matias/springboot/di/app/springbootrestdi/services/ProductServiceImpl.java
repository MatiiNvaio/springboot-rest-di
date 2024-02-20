package com.matias.springboot.di.app.springbootrestdi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.matias.springboot.di.app.springbootrestdi.models.Product;
import com.matias.springboot.di.app.springbootrestdi.repositories.IProductRespository;

@Service
public class ProductServiceImpl implements IProductService{
    
    @Autowired
    // @Qualifier("repositoryFoo")
    private IProductRespository productRepository;

    @Value("${config.double.tax}")
    private Double tax;
    /*
        podemos inyectar de esta manera sobre el metodo setter o sobre el mismo objeto productRepository, o tambien en el constructor
        @Qualifire le da prioridad a la implementacion la cual se pone el nombre, simore empieza con minuscula

        public void setProductRepository(@Qualifier("repositoryFoo") IProductRespository productRepository) {
            this.productRepository = productRepository;
        }
    */
    
    @Override
    public List<Product> findAll(){

        // con stream().map() podemos acceder a los objetos y manipularlos
        return productRepository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * tax;
            // nuevo objeto Product con los datos obtenidos del map, para respetar el principio de inmutabilidad
            // no se va a modificar en cada flujo que se cree
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
            // p.setPrice(priceImp.longValue());
            // return p;
        }).toList(); // convierte el stream en una lista, asi podemos retornar
    }
 
    @Override
    public Product findById(Long id){
        Product product = productRepository.findById(id);

        return product;
    }

    
}

package com.matias.springboot.di.app.springbootrestdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.matias.springboot.di.app.springbootrestdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
})
public class SpringConfig {

    @Value("classpath:json/product.json")
    private Resource resource;
    @Bean
    @Primary
    ProductRepositoryJson productJsonBean(){
        return new ProductRepositoryJson();
    }
}

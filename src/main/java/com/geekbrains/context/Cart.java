package com.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository productRepository;
    private HashMap<Integer, Product> products = new HashMap<>();

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id){
        Product product = productRepository.getByID(id);
        if(!(product == null)){
            products.put(id, product);
        }
    }

    public void removeProduct(int id){
        products.remove(id);
    }

}

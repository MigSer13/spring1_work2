package com.geekbrains.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
           new Product(1, "Яблоко", 15L),
           new Product(2, "Хлеб", 41L),
           new Product(3, "Огурец", 13L),
           new Product(4, "Молоко", 60L),
           new Product(5, "Сок", 75L)
        ));
    }

    public Product getByID(int id){
        for(Product p : productList){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductList() {
        return productList;
    }
}

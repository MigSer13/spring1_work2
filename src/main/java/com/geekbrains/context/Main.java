package com.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = appContext.getBean(Cart.class);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String command = sc.nextLine().trim();
            if(command.startsWith("add")){
                int id = Integer.parseInt(command.split(" ")[1]);
                cart.addProduct(id);
            }
            if(command.startsWith("remove")){
                int id = Integer.parseInt(command.split(" ")[1]);
                cart.removeProduct(id);
            }
            if(command.startsWith("newCart")){
                cart = appContext.getBean(Cart.class);
            }
            if(command.startsWith("show")){
                if(!cart.getProducts().isEmpty()){
                    for(Map.Entry entry : cart.getProducts().entrySet()){
                        System.out.println(entry);
                    }
                } else {
                    System.out.println("Корзина пуста");
                }

            }
        }
    }
}

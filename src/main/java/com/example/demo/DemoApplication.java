package com.example.demo;

import com.example.demo.domain.Product;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start(ProductService productService){
        return args -> {
            /**
            productService.save(new Product( null,"productName",21.4F, UUID.randomUUID().toString()));
            productService.save(new Product( null,"productName2",25.4F, UUID.randomUUID().toString()));
            productService.save(new Product( null,"productName3",51.4F, UUID.randomUUID().toString()));
            productService.save(new Product( null,"productName4",81.4F, UUID.randomUUID().toString()));



            userServices.createRole(new Role(null,"CLIENT"));
            userServices.createRole(new Role(null,"STOCK_MANAGER"));
            userServices.createRole(new Role(null,"FOURNISSEUR"));


            userServices.createUser(new User(null,"taha","taha2000",new ArrayList<>()));
            userServices.createUser(new User(null,"mohamed","taha2000",new ArrayList<>()));
            userServices.createUser(new User(null,"amine","taha2000",new ArrayList<>()));
            userServices.createUser(new User(null,"dzak","taha2000",new ArrayList<>()));
            userServices.createUser(new User(null,"zineb","taha2000",new ArrayList<>()));


            userServices.addRoleToUser("Client","zineb");
            userServices.addRoleToUser("Client","taha");
            userServices.addRoleToUser("STOCK_MANAGER","mohamed");
            userServices.addRoleToUser("FOURNISSEUR","amine");
            **/


        };
    }
}

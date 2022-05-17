package com.example.kotikiadministrator;

import com.example.kotikiadministrator.entities.Kotik;
import com.example.kotikiadministrator.entities.Owner;
import com.example.kotikiadministrator.entities.Role;
import com.example.kotikiadministrator.entities.Users;
import com.example.kotikiadministrator.enumClass.Breed;
import com.example.kotikiadministrator.enumClass.Color;
import com.example.kotikiadministrator.service.KotikService;
import com.example.kotikiadministrator.service.OwnerService;
import com.example.kotikiadministrator.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.time.LocalDate;

@SpringBootApplication
public class KotikiAdministratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(KotikiAdministratorApplication.class, args);
    }
    @Bean
    CommandLineRunner run(UserService userService, OwnerService ownerService, KotikService kotikiService) {
        return args -> {
            Users user = new Users("mary", "12345", Role.ADMIN);
            userService.save(user);
            Users user1 = new Users("lox", "12345", Role.USER);
            userService.save(user1);
            Owner owner = new Owner("vasya", LocalDate.now());
            ownerService.save(owner);
            user.setOwner(owner);
            userService.save(user);
            Owner owner1 = new Owner("vasya", LocalDate.now());
            ownerService.save(owner1);
            user1.setOwner(owner1);
            userService.save(user1);
            Kotik kotiki = new Kotik("simon", LocalDate.now(), Breed.British, Color.Red, owner);
            kotikiService.save(kotiki);
        };
    }
}

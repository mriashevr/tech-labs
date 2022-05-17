package com.example.kotikiadministrator.controller;

import com.example.kotikiadministrator.entities.Owner;
import com.example.kotikiadministrator.entities.Users;
import com.example.kotikiadministrator.service.UserService;
import com.example.kotikiadministrator.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String HelloKotik() {
        return "Hello Kotik haver!";
    }
    @GetMapping("/findById")
    public ResponseEntity<Users> findById(Integer id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @GetMapping( "/admin/findAll")
    public ResponseEntity<Collection<UserWrapper>> findAll(){
        return new ResponseEntity<>(userService.findAll().stream()
                .map((users -> users.UserWrapper()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }
    @PostMapping(value = "/update")
    public ResponseEntity<Users> update(@RequestBody Users user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }
    @PostMapping(value = "/admin/delete")
    public ResponseEntity<Owner> delete(@RequestBody Users user){
        userService.delete(user);
        return ResponseEntity.ok().build();
    }
}

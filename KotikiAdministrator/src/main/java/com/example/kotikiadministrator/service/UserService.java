package com.example.kotikiadministrator.service;

import com.example.kotikiadministrator.entities.Users;

import java.util.List;

public interface UserService {
    Users findById(Integer id);
    List<Users> findAll();

    void save(Users user);

    Users update(Users user);

    void delete(Users user);
}

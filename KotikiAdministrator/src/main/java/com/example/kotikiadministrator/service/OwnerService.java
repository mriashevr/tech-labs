package com.example.kotikiadministrator.service;

import com.example.kotikiadministrator.entities.Owner;

import java.util.List;

public interface OwnerService {
    Owner findById(Integer id);
    List<Owner> findAll();

    void save(Owner owner);

    Owner update(Owner owner);

    void delete(Owner owner);
}

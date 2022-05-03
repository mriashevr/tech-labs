package com.example.kotikserverjpa.service;

import com.example.kotikserverjpa.entities.Kotik;
import com.example.kotikserverjpa.entities.Owner;

import java.util.List;

public interface OwnerService {
    Owner findById(Integer id);
    List<Owner> findAll();

    void save(Owner owner);

    Owner update(Owner owner);

    void delete(Owner owner);
}

package com.example.kotikiadministrator.service;

import com.example.kotikiadministrator.entities.Kotik;
import com.example.kotikiadministrator.enumClass.Breed;
import com.example.kotikiadministrator.enumClass.Color;

import java.util.Collection;
import java.util.List;

public interface KotikService {
    Kotik findById(Integer id);

    List<Kotik> findAll();

    Kotik save(Kotik kotik);

    Kotik update(Kotik kotik);

    void delete(Kotik kotik);

    void addFriend(Kotik kotik1, Kotik kotik2);
    Collection<Kotik> getKotikByBreed(Breed breed);
    Collection<Kotik> getKotikByColor(Color color);
}

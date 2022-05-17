package com.example.kotikiadministrator.repository;

import com.example.kotikiadministrator.entities.Kotik;
import com.example.kotikiadministrator.enumClass.Breed;
import com.example.kotikiadministrator.enumClass.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface KotikRepository extends JpaRepository<Kotik, Integer> {
    Collection<Kotik> getKotikByColor(Color color);
    Collection<Kotik> getKotikByBreed(Breed breed);
}

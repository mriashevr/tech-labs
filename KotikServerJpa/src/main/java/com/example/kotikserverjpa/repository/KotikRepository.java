package com.example.kotikserverjpa.repository;

import com.example.kotikserverjpa.entities.Kotik;
import com.example.kotikserverjpa.entities.Owner;
import com.example.kotikserverjpa.enumClass.Breed;
import com.example.kotikserverjpa.enumClass.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface KotikRepository extends JpaRepository<Kotik, Integer> {
    Collection<Kotik> getKotikByColor(Color color);
    Collection<Kotik> getKotikByBreed(Breed breed);
}

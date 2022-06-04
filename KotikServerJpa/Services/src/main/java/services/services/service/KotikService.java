package services.services.service;

import services.services.entities.Kotik;
import services.services.enumClass.Breed;
import services.services.enumClass.Color;

import java.util.Collection;
import java.util.List;

public interface KotikService {
    Kotik findById(Integer id);

    List<Kotik> findAll();

    Kotik save(Kotik kotik);

    Kotik update(String json);

    void delete(Kotik kotik);

    void addFriend(Kotik kotik1, Kotik kotik2);
    Collection<Kotik> getKotikByBreed(Breed breed);
    Collection<Kotik> getKotikByColor(Color color);
}

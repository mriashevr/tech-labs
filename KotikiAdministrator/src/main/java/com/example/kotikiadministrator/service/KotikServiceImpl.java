package com.example.kotikiadministrator.service;
import com.example.kotikiadministrator.entities.Kotik;
import com.example.kotikiadministrator.entities.Kotikbodies;
import com.example.kotikiadministrator.enumClass.Breed;
import com.example.kotikiadministrator.enumClass.Color;
import com.example.kotikiadministrator.repository.KotikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class KotikServiceImpl implements KotikService {

    private final KotikRepository kotikRepository;

    @Autowired
    public KotikServiceImpl(KotikRepository kotikRepository){
        this.kotikRepository = kotikRepository;
    }

    @Override
    public Kotik findById(Integer id) {
        return kotikRepository.findById(id).get();
    }

    @Override
    public List<Kotik> findAll() {
        return kotikRepository.findAll();
    }

    @Override
    public Kotik save(Kotik kotik) {
        kotikRepository.save(kotik);
        return kotik;
    }

    @Override
    public Kotik update(Kotik kotik) {
        kotikRepository.save(kotik);
        return kotik;
    }

    @Override
    public void delete(Kotik kotik) {
        kotikRepository.delete(kotik);
    }

    @Override
    public void addFriend(Kotik kotik1, Kotik kotik2){
        Kotikbodies friends = new Kotikbodies(kotik1, kotik2);
    }

    @Override
    public Collection<Kotik> getKotikByColor(Color color) {
       return kotikRepository.getKotikByColor(color);
    }
    @Override
    public Collection<Kotik> getKotikByBreed(Breed breed){
        return kotikRepository.getKotikByBreed(breed);
    }
}

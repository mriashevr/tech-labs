package com.example.kotikserverjpa.service;
import com.example.kotikserverjpa.entities.Kotik;
import com.example.kotikserverjpa.entities.Kotikbodies;
import com.example.kotikserverjpa.enumClass.Breed;
import com.example.kotikserverjpa.enumClass.Color;
import com.example.kotikserverjpa.repository.KotikRepository;
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

    public Kotik findById(Integer id) {
//        Kotik kotik = kotikRepository.getById(id);
        return kotikRepository.findById(id).get();
    }

    public List<Kotik> findAll() {
        return kotikRepository.findAll();
    }

    public Kotik save(Kotik kotik) {
        kotikRepository.save(kotik);
        return kotik;
    }

    public Kotik update(Kotik kotik) {
        kotikRepository.save(kotik);
        return kotik;
    }

    public void delete(Kotik kotik) {
        kotikRepository.delete(kotik);
    }

    public void addFriend(Kotik kotik1, Kotik kotik2){
        Kotikbodies friends = new Kotikbodies(kotik1, kotik2);
    }

    public Collection<Kotik> getKotikByColor(Color color) {
       return kotikRepository.getKotikByColor(color);
    }
    public Collection<Kotik> getKotikByBreed(Breed breed){
        return kotikRepository.getKotikByBreed(breed);
    }
}

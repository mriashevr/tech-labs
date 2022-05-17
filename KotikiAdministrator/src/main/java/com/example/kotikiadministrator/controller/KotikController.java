package com.example.kotikiadministrator.controller;


import com.example.kotikiadministrator.entities.Kotik;
import com.example.kotikiadministrator.entities.Kotikbodies;
import com.example.kotikiadministrator.enumClass.Breed;
import com.example.kotikiadministrator.enumClass.Color;
import com.example.kotikiadministrator.service.KotikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "kotiki")
public class KotikController {

    private final KotikServiceImpl kotikService;

    @Autowired
    public KotikController(KotikServiceImpl kotikService) {
        this.kotikService = kotikService;
    }

    @GetMapping(value = "get")
    public ResponseEntity<Kotik> getCat(Integer id) {
//        Kotik kot = kotikService.findById(id);
//        return new ResponseEntity(new KotikWrapper(kot.getId(), kot.getName(), kot.getBirthday(),
//                kot.getBreed().name(), kot.getColor().name(), kot.getOwner().getId()), HttpStatus.OK);
        return new ResponseEntity<>(kotikService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "GetAll")
    public ResponseEntity<Collection<Kotik>> GetAll() {
        return new ResponseEntity<>(kotikService.findAll(), HttpStatus.OK);
    }
    @PostMapping(value = "Update")
    public ResponseEntity<Kotik> Update(@RequestBody Kotik kotik) {
        return new ResponseEntity<>(kotikService.update(kotik), HttpStatus.OK);
    }
    @PostMapping(value = "delete")
    public ResponseEntity<Kotik> Delete(@RequestBody Kotik kotik) {
        kotikService.delete(kotik);
        return ResponseEntity.ok().build();
    }
    @PostMapping(value = "AddFriend")
    public ResponseEntity<Kotikbodies> AddFriend(@RequestBody Kotik kotik, @RequestBody Kotik kotik2){
        kotikService.addFriend(kotik, kotik2);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "GetByColor")
    public ResponseEntity<Collection<Kotik>> GetByColor(@RequestParam(value = "color") Color color){
        return new ResponseEntity<>(kotikService.getKotikByColor(color), HttpStatus.OK);
    }
    @GetMapping(value = "GetByBreed")
    public ResponseEntity<Collection<Kotik>> GetByBreed(@RequestParam(value = "breed") Breed breed){
        return new ResponseEntity<>(kotikService.getKotikByBreed(breed), HttpStatus.OK);
    }
}

package com.example.kotikiadministrator.controller;

import com.example.kotikiadministrator.entities.Owner;
import com.example.kotikiadministrator.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "findById")
    public ResponseEntity<Owner> findById(Integer id) {
        return new ResponseEntity<>(ownerService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "findAll")
    public ResponseEntity<Collection<Owner>> findAll(){
        return new ResponseEntity<>(ownerService.findAll(), HttpStatus.OK);
    }
    @PostMapping(value = "update")
    public ResponseEntity<Owner> update(@RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.update(owner), HttpStatus.OK);
    }
    @PostMapping(value = "delete")
    public ResponseEntity<Owner> delete(@RequestBody Owner owner){
        ownerService.delete(owner);
        return ResponseEntity.ok().build();
    }
}

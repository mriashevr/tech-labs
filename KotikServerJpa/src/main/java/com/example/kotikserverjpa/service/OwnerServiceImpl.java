package com.example.kotikserverjpa.service;


import com.example.kotikserverjpa.entities.Kotik;
import com.example.kotikserverjpa.entities.Owner;
import com.example.kotikserverjpa.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownersRep){
        this.ownerRepository = ownersRep;
    }
    public Owner findById(Integer id) {
//        Owner owner = ownerRepository.getById(id);
        return ownerRepository.findById(id).get();
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    public Owner update(Owner owner) {
       return ownerRepository.save(owner);
    }

    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}

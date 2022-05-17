package com.example.kotikiadministrator.service;


import com.example.kotikiadministrator.entities.Owner;
import com.example.kotikiadministrator.repository.OwnerRepository;
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

    @Override
    public Owner findById(Integer id) {
        return ownerRepository.findById(id).get();
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
       return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}

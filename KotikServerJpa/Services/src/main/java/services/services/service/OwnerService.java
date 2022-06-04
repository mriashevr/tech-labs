package services.services.service;

import services.services.entities.Owner;

import java.util.List;

public interface OwnerService {
    Owner findById(Long id);
    List<Owner> findAll();

    Owner update(String owner);
    void delete(Owner owner);
}

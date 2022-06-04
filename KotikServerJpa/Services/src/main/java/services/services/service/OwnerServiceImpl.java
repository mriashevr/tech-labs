package services.services.service;


import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.services.entities.Owner;
import services.services.repository.OwnerRepository;
import services.services.wrapper.OwnerWrapper;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownersRep){
        this.ownerRepository = ownersRep;
    }
    public Owner findById(Long id) {
        return ownerRepository.findById(id).get();
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }


    public Owner update(String json) {
        var data = new GsonBuilder().create().fromJson(json, OwnerWrapper.class);

        var owner = new Owner(data.getName(), data.getBirthday());
        return ownerRepository.save(owner);
    }

    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}

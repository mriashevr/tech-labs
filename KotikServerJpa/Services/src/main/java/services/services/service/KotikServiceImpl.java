package services.services.service;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import services.services.entities.Kotik;
import services.services.entities.Kotikbodies;
import services.services.enumClass.Breed;
import services.services.enumClass.Color;
import services.services.repository.KotikRepository;
import services.services.wrapper.KotikWrapper;

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
        return kotikRepository.findById(id).get();
    }

    public List<Kotik> findAll() {
        return kotikRepository.findAll();
    }

    public Kotik save(Kotik kotik) {
        kotikRepository.save(kotik);
        return kotik;
    }

    @KafkaListener(id = "kotiki-update", topics = {"kotiki.update"}, containerFactory = "singleFactory")
    public Kotik update(String json) {
        var data = new GsonBuilder().create().fromJson(json, KotikWrapper.class);

        var kotik = new Kotik(data.getName(), data.getBirthday(),
                Breed.valueOf(data.getBreed()) , Color.valueOf(data.getColor()), data.getOwner());
        return kotikRepository.save(kotik);
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

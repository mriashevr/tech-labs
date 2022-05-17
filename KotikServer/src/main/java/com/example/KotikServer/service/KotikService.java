package com.example.KotikServer.service;

import com.example.KotikServer.entities.Kotik;
import com.example.KotikServer.entities.Kotikbodies;

import java.util.ArrayList;

public class KotikService {
    private KotikDao kotiksDao;

    public ServiceKotik(KotikDao kotiksDao){
        this.kotiksDao = kotiksDao;
    }

    public Kotik findById(Integer id) {
        Kotik kotik = kotiksDao.get(id);
        return kotik;
    }

    public ArrayList<Kotik> findAll() {
        return kotiksDao.getAll();
    }

    public Kotik save(Kotik kotik) {
        kotiksDao.save(kotik);
        return kotik;
    }

    public void update(Kotik kotik) {
        kotiksDao.update(kotik);
    }

    public void delete(Kotik kotik) {
        kotiksDao.delete(kotik);
    }

    public void addFriend(Kotik kotik1, Kotik kotik2){
        Kotikbodies friends = new Kotikbodies(kotik1, kotik2);
    }
}

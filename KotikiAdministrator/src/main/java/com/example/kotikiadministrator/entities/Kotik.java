package com.example.kotikiadministrator.entities;
import com.example.kotikiadministrator.enumClass.Breed;
import com.example.kotikiadministrator.enumClass.Color;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kotiki")
public class Kotik {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "breed")
    @Enumerated(EnumType.STRING)
    private Breed breed;
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;
//    @Column(name = "owner")
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToMany
    @JoinTable(name = "kotikbodies",
            joinColumns = @JoinColumn(name = "id_general"),
            inverseJoinColumns = @JoinColumn(name = "id_friend"))
    private List<Kotik> kotiks;

    public Kotik(String name, LocalDate birthday, Breed breed, Color color, Owner owner){
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
        kotiks = new ArrayList<>();
    }

    public Kotik() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Kotik> getKotiks() {
        return kotiks;
    }

    public void setKotiks(List<Kotik> kotiks) {
        this.kotiks = kotiks;
    }
}
